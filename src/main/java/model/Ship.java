package model;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    public ShipType size;
    public Orientation orientation;
    public List<Square> locations;

    public Ship(ShipType size) {
        this.size = size;
        locations = new ArrayList<>(size.getLength());
    }
}
