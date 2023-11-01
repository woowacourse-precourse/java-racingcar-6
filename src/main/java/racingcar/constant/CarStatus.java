package racingcar.constant;

public enum CarStatus {
    FORWARD("-"),
    STOP("");
    private final String output;

    CarStatus(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
