package racingcar;

public interface UserInputHandler <T> {
    public void handle(String userInput);
    public T getHandledResult();
}
