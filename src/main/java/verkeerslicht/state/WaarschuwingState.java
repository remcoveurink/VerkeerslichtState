package verkeerslicht.state;

import verkeerslicht.Verkeerslicht;
import verkeerslicht.VerkeerslichtState;

public class WaarschuwingState extends VerkeerslichtState {
    private static final long BLINK_INTERVAL = 1000;
    private long laatsteKnipper;
    private boolean laatsteStatus;

    public WaarschuwingState(Verkeerslicht verkeerslicht) {
        super(verkeerslicht);
    }

    @Override
    public void entry() {
        laatsteKnipper = entryTijd;
        laatsteStatus = true;
        verkeerslicht.setGeel(true);
    }

    @Override
    public void doe() {
        long huidigeTijd = System.currentTimeMillis();
        if(huidigeTijd - laatsteKnipper > BLINK_INTERVAL) {
            laatsteKnipper = huidigeTijd;
            laatsteStatus = !laatsteStatus;
            verkeerslicht.setGeel(laatsteStatus);
        }
    }

    @Override
    public void exit() {
        verkeerslicht.setGeel(false);
    }

    @Override
    public void afhandelenInput(String input) {
        exit(new StopState(verkeerslicht));
    }
}
