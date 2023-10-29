package racingcar;

public class Configurations {
    private int minimumOfRange;
    private int maximumOfRange;
    private int numberOfCars;


    Configurations(int numberOfCars) {
        minimumOfRange = 0;
        maximumOfRange = 9;
        this.numberOfCars = numberOfCars;
    }

    public int getMinimumOfRange() {
        return minimumOfRange;
    }

    public int getMaximumOfRange() {
        return maximumOfRange;
    }

    public int getNumberOfNumbers() {
        return numberOfCars;
    }



}
