package racingcar.model;

public class Car implements Comparable<Car>{
    public String name;
    public int length;

    public Car(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    @Override
    public int compareTo(Car o) {
        return o.length - this.length;
    }
}

