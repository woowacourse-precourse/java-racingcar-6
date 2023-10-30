package racingcar.domain.game;

import java.util.List;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

public class RacingGame {
    private RacingGameInputView inputView = new RacingGameInputView();
    private RacingGameOutputView outputView = new RacingGameOutputView();

    public void start() {
        // 자동차 이름 입력
        outputView.printCarNameInputMessage();
        String[] inputCars = inputView.nextStringArray();

        // 시도할 회수 입력
        outputView.printRacingRoundInputMessage();
        int num = RacingGameInputView.nextInt();

        List<RacingCar> cars = RacingCars.fromNames(inputCars);
        Racing racing = new Racing(cars, num);


    }
}
