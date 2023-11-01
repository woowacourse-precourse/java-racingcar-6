package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.domain.WinnerPicker;
import racingcar.input.Input;
import racingcar.output.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output output = new Output();
        Input input = new Input(output);
        WinnerPicker winnerPicker = new WinnerPicker();

        RacingCarGame racingCarGame = new RacingCarGame(output, input, winnerPicker);
        racingCarGame.play();
    }
}
