package verkeerslicht.state;

import verkeerslicht.Verkeerslicht;
import verkeerslicht.VerkeerslichtState;

public class StopState extends VerkeerslichtState {
    private static final long STOP_INTERVAL = 3000;
    public StopState(Verkeerslicht verkeerslicht) {
        super(verkeerslicht);
    }

    @Override
    protected void entry() {
        verkeerslicht.setRood(true);
    }

    @Override
    public void doe() {
        if(System.currentTimeMillis() - entryTijd > STOP_INTERVAL) {
            exit();
            verkeerslicht.setState(new RijdenState(verkeerslicht));
        }
    }

    @Override
    protected void exit() {
        verkeerslicht.setRood(false);
    }

    @Override
    public void afhandelenInput(String input) {
        exit();
        verkeerslicht.setState(new WaarschuwingState(verkeerslicht));
    }
}
