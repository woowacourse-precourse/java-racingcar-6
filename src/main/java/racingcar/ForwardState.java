package racingcar;

public class ForwardState {
    private static final String SLASH = "-";
    private final String forwardState;


    public ForwardState(int count) {
        this.forwardState = switchCountToSlash(count);
    }

    private String switchCountToSlash(int count) {
        return SLASH.repeat(count);
    }

    public String getForwardState() {
        return forwardState;
    }
}
