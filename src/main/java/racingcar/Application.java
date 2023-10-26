package racingcar;

import racingcar.domain.Input;
import racingcar.domain.Output;
import racingcar.domain.RandomNumberGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        output.CarNameInputMessage();
        List<String> carNames = input.inputCarNames();
        output.gameCountInputMessage();
        int gameCount = input.inputGameCount();

    }
}
