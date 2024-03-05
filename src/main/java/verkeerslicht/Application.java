package verkeerslicht;

import java.util.Scanner;
import java.util.concurrent.*;

public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Verkeerslicht verkeerslicht = new Verkeerslicht();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        scheduler.scheduleAtFixedRate(() -> executorService.execute(verkeerslicht::periodiekeTrigger),
                20, 10, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(() -> executorService.execute(() ->
                        System.out.println(verkeerslicht.getLampen())),
                10, 1000, TimeUnit.MILLISECONDS);
        ScheduledFuture<?> future = scheduler.schedule(() ->
                mainThread(verkeerslicht), 0, TimeUnit.MILLISECONDS);
        future.get(); // wait for mainThread to finish
        scheduler.close();
    }

    private static void mainThread(Verkeerslicht verkeerslicht) {
        Scanner s = new Scanner(System.in);
        String line = "";
        while(!line.equals("exit")) {
            line = s.nextLine();
            verkeerslicht.afhandelenInput(line);
        }
    }
}
