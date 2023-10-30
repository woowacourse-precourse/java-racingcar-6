package racingcar;

public interface OutputView {
    void outputMessage(String message);
    default void outputMessage(OutputMessage outputMessage) {
        outputMessage(outputMessage.getMessage());
    }
}
