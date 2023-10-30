package racingcar;

public interface OutputView {
    void print(String message);
    default void print(OutputMessage outputMessage) {
        print(outputMessage.getMessage());
    }
}
