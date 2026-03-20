package federicolepore.entities;

public enum Players {
    DUE(2),
    TRE(3),
    QUATTRO(4),
    CINQUE(5),
    SEI(6),
    SETTE(7),
    OTTO(8),
    NOVE(9),
    DIECI(10);

    private final int value;

    Players(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
