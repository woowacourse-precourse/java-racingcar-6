package racingcar;

public class Configurations {
    private int minimumOfRange;
    private int maximumOfRange;
    private int numberOfNumbers;
    private String delimiter;
    private int controlValue;
    private int movingDistance;
    private int maximumNameLength;

    Configurations() {
        minimumOfRange = 0;
        maximumOfRange = 9;
        delimiter = ",";
        controlValue = 4;
        movingDistance = 1;
        maximumNameLength = 5;
    }

    public int getMinimumOfRange() {
        return minimumOfRange;
    }

    public int getMaximumOfRange() {
        return maximumOfRange;
    }

    public String getDelimiter(){
        return delimiter;
    }
    public int getNumberOfNumbers() {
        return numberOfNumbers;
    }
    public int getControlValue() {
        return controlValue;
    }
    public int getMovingDistance(){
        return movingDistance;
    }

}
