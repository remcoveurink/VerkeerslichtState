package verkeerslicht.state;

import verkeerslicht.Verkeerslicht;
import verkeerslicht.VerkeerslichtState;

public class RemmenState extends VerkeerslichtState {
    private static final long REM_INTERVAL = 2000;
    public RemmenState(Verkeerslicht verkeerslicht) {
        super(verkeerslicht);
    }

    @Override
    public void entry() {
        verkeerslicht.setGeel(true);
    }

    @Override
    public void doe() {
        if(System.currentTimeMillis() - entryTijd > REM_INTERVAL) {
            exit();
            verkeerslicht.setState(new StopState(verkeerslicht));
        }
    }

    @Override
    public void exit() {
        verkeerslicht.setGeel(false);
    }

    @Override
    public void afhandelenInput(String input) {
        // doe niks
    }
}
