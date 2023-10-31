package racingcar.domain;

public class InputMoveNumber extends Input {
    private final static String message = "시도할 회수는 몇회인가요?";
    public InputMoveNumber() {
        print(message);
        input();
    }

}
