package racingcar.constants;

public enum GameResultElement {
    COLON(" : "),
    DASH("-"),
    COMMA(", "),
    ENTER("\n");

    private final String element;

    GameResultElement(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    @Override
    public String toString() {
        return element;
    }
}
