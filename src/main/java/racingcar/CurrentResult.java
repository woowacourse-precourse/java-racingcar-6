package racingcar;

public class CurrentResult {
    private final String name;
    private final String forwardStatus;

    public CurrentResult(String name, String forwardStatus) {
        this.name = name;
        this.forwardStatus = forwardStatus;
    }

    public String getName() {
        return name;
    }

    public String getForwardStatus() {
        return forwardStatus;
    }
}
