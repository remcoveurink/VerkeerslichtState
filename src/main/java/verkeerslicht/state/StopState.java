package verkeerslicht.state;

import verkeerslicht.Verkeerslicht;
import verkeerslicht.VerkeerslichtState;

public class StopState extends VerkeerslichtState {
    private static final long STOP_INTERVAL = 3000;
    public StopState(Verkeerslicht verkeerslicht) {
        super(verkeerslicht);
    }

    @Override
    public void entry() {
        verkeerslicht.setRood(true);
    }

    @Override
    public void doe() {
        if(System.currentTimeMillis() - entryTijd > STOP_INTERVAL) {
            exit(new RijdenState(verkeerslicht));
        }
    }

    @Override
    public void exit() {
        verkeerslicht.setRood(false);
    }

    @Override
    public void afhandelenInput(String input) {
        exit(new WaarschuwingState(verkeerslicht));
    }
}
