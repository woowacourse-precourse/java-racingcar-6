package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.model.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.out);
        OutputView outputView = new OutputView(System.out);
        NumberGenerator randomNumberGenerator = () -> Randoms.pickNumberInRange(0, 9);


        RacingSimulator racingSimulator = new RacingSimulator(inputView, outputView);
        racingSimulator.simulate(randomNumberGenerator);
    }
}
