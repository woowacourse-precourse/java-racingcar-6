package game;

public class Car implements Comparable<Car> {
    public static final int FORWARD_STANDARD = 4;
    private String name;
    private int distance;
    Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move() {
        if(RandomNumberGenerator.getRandomNumber() >= FORWARD_STANDARD) {
            distance++;
        }
    }

    @Override
    public int compareTo(Car o) {
        return o.distance - this.distance;
    }
}
