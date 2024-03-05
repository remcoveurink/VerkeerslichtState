package verkeerslicht;

import verkeerslicht.state.WaarschuwingState;

public class Verkeerslicht {
    private VerkeerslichtState huidigeState;
    private boolean rood;
    private boolean geel;
    private boolean groen;

    public Verkeerslicht() {
        //begin state
        this.huidigeState = new WaarschuwingState(this);
    }

    public void setState(VerkeerslichtState state) {
        this.huidigeState = state;
    }

    public void setRood(boolean rood) {
        this.rood = rood;
    }

    public void setGeel(boolean geel) {
        this.geel = geel;
    }

    public void setGroen(boolean groen) {
        this.groen = groen;
    }

    public synchronized void periodiekeTrigger() {
        huidigeState.doe();
    }

    public synchronized void afhandelenInput(String input) {
        huidigeState.afhandelenInput(input);
    }

    public synchronized String getLampen() {
        return String.format("rood: %s, geel: %s, groen: %s",
                vertaal(rood), vertaal(geel), vertaal(groen));
    }

    private static String vertaal(boolean trueOrFalse) {
        return trueOrFalse ? "on" : "off";
    }
}
