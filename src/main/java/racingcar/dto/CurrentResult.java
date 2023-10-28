package racingcar.dto;

public class CurrentResult {
    private final String name;
    private final ForwardState forwardState;

    public CurrentResult(String name, ForwardState forwardState) {
        this.name = name;
        this.forwardState = forwardState;
    }

    public String getName() {
        return name;
    }

    public String getForwardStatus() {
        return forwardState.getForwardState();
    }
}
