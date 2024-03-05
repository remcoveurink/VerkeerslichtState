package verkeerslicht;

public abstract class VerkeerslichtState {
    protected final long entryTijd;
    protected final Verkeerslicht verkeerslicht;

    public VerkeerslichtState(Verkeerslicht verkeerslicht) {
        this.verkeerslicht = verkeerslicht;
        entryTijd = System.currentTimeMillis();
        entry();
    }

    public abstract void afhandelenInput(String input);

    protected abstract void entry();

    protected abstract void doe();

    protected abstract void exit();
}
