package racingcar.model;

public enum CarGear {
    FORWARD(1),
    STOP(0);
    private int gearNumber;

    CarGear(int gearNumber) {
        this.gearNumber = gearNumber;
    }
}
