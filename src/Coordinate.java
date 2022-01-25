import java.util.Objects;

public class Coordinate {
    int i;
    int j;
    int priority;
    Direction direction;
    public Coordinate(int i, int j, int priority) {
        this.i = i;
        this.j = j;
        this.priority = priority;
    }

    public Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return i == that.i && j == that.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
