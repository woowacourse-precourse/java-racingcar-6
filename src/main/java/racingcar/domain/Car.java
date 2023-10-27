package racingcar.domain;

public class Car implements Comparable<Car> {

    private String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public int generateRandomNumber(){

        return 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {

        return this.forwardCount - o.forwardCount;
    }
}
