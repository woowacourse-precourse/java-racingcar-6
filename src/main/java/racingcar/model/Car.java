package racingcar.model;

public class Car implements Comparable<Car> {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setPosition(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
        //this.position += position;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Car car) {
        if (car.position < position) {
            return 1;
        }
        if (car.position > position) {
            return -1;
        }
        return 0;
    }
}
