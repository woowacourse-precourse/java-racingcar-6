package racingcar.model;

public enum CarStatus {
    FORWARD("-"),
    STOP("");
    private String output;

    CarStatus(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
