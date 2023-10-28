package racingcar.model;

public class Car {
    private final String carName;
    private String countingMove = "";

    public Car(String carName) {
        this.carName = carName;
    }

    public Integer carResult() {
        return countingMove.length();
    }

    public void forwardCar(boolean ifForward) {
        if (ifForward) {
            this.countingMove += "-";
        }
    }

    public String getCarName() {
        return this.carName;
    }

    public boolean ifImWinner(Integer maxCountingMove) {
        return maxCountingMove == countingMove.length();
    }

    @Override
    public String toString() {
        return this.carName + " : " + this.countingMove + "\n";
    }
}
