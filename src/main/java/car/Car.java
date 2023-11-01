package car;

public class Car implements Move {

    private final CarName name;
    private int position;
    public Car(String name) {
        this.name = new CarName(name);
        this.position = 0;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void move() {
        this.position++;
    }
}
