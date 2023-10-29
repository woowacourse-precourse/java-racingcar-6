package racingcar.dto;

public class CarState {
    private final String name;
    private final ForwardState forwardState;

    public CarState(String name, ForwardState forwardState) {
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
