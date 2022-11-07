package model;

public enum ShipType {
    SMALL("s", 2),
    MEDIUM("m", 3),
    LARGE("l", 4),
    GIANT("g", 5);

    private int length;
    private String label;

    ShipType(String label, int length) {
        this.label = label;
        this.length = length;
    }

    public String getLabel() {
        return label;
    }

    public int getLength() {
        return length;
    }
}
