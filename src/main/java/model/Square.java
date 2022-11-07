package model;

import java.util.Objects;

/**
 * Represents a square on Board.
 */
public class Square {
    public int x;
    public int y;
    public SquareStatus status;

    public Square(int x, int y, SquareStatus status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return x == square.x && y == square.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
