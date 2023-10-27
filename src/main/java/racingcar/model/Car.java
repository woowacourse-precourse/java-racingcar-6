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

    public String ifImWinner(Integer maxCountingMove) {
        if (maxCountingMove != countingMove.length()) {
            return "";
        }

        return this.carName;
    }

    @Override
    public String toString() {
        return this.carName + " : " + this.countingMove + "\n";
    }
}
