package racingcar.model;

public class Car implements Comparable<Car> {
    private String name;
    private Long distance;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        distance = 0L;
        this.numberGenerator = numberGenerator;
    }

    public void moveOrStay() {
        int decisionNumber = numberGenerator.generateNumber();

        if (decisionNumber >= 4) {
            distance++;
        }
    }

    @Override
    public int compareTo(Car otherCar) {
        return Long.compare(this.distance, otherCar.distance);
    }

    public String getName() {
        return name;
    }

    public Long getDistance() {
        return distance;
    }
}