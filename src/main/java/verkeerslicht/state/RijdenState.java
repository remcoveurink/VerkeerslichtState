package verkeerslicht.state;

import verkeerslicht.Verkeerslicht;
import verkeerslicht.VerkeerslichtState;

public class RijdenState extends VerkeerslichtState {
    private static final long RIJ_INTERVAL = 5000;
    public RijdenState(Verkeerslicht verkeerslicht) {
        super(verkeerslicht);
    }

    @Override
    protected void entry() {
        verkeerslicht.setGroen(true);
    }

    @Override
    public void doe() {
        if(System.currentTimeMillis() - entryTijd > RIJ_INTERVAL) {
            exit();
            verkeerslicht.setState(new RemmenState(verkeerslicht));
        }
    }

    @Override
    protected void exit() {
        verkeerslicht.setGroen(false);
    }

    @Override
    public void afhandelenInput(String input) {
        // doe niks
    }
}
