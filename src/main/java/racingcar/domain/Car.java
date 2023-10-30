package racingcar.domain;

public class Car implements Comparable<Car>{
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goToPosition(){
        this.position += 1;
    }

    public boolean isSamePosition(Car other) {
        return other.position == this.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

}
