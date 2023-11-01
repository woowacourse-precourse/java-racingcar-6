package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.factory.CarFactory;
import racingcar.domain.factory.ParticipantsFactory;
import racingcar.domain.RandomMoveEngine;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory(new RandomMoveEngine());
        ParticipantsFactory participantsFactory = new ParticipantsFactory(carFactory);
        RacingCarController racingCarController =
                new RacingCarController(new InputView(), new OutputView(), participantsFactory);

        racingCarController.run();
    }
}
