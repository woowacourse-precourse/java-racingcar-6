package racingcar.constants;

public enum GameResultElement {
    COLON(" : "),
    DASH("-"),
    ENTER("\n");

    private final String element;

    GameResultElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element;
    }
}
