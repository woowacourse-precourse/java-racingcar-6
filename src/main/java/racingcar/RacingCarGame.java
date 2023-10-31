package racingcar;

import java.util.List;
import racingcar.utils.Validator;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class RacingCarGame {
    private Integer iterNumber = 0;

    public void gameStart() {
        RacingCarInputView racingCarInputView = new RacingCarInputView();

        String names = racingCarInputView.carNameInput();
        Cars cars = new Cars(names);

        String number = racingCarInputView.carNumberInput();
        Validator.validateNumber(number);
        iterNumber = Integer.parseInt(number);

        RacingCarOutputView racingCarOutputView = new RacingCarOutputView();
        racingCarOutputView.moveResultPrint(iterNumber, cars);

        List<String> winners = cars.findWinner(cars);
        racingCarOutputView.winnerPrint(winners);

    }
}
