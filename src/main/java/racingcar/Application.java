package racingcar;

public class Application {
    public static void main(String[] args) {
        String[] names = InputView.inputToArray(InputView.carInput());
        int roundCount = InputView.inputToInt(InputView.roundInput());
        RacingStart game = new RacingStart();
        game.start(names, roundCount);

    }
}
