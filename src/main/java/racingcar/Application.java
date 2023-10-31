package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.CarFactory;
import racingcar.domain.CarNameValidator;
import racingcar.domain.CarsValidator;
import racingcar.domain.ParticipantsFactory;
import racingcar.domain.RandomMoveEngine;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory(new RandomMoveEngine(), new CarNameValidator());
        ParticipantsFactory participantsFactory = new ParticipantsFactory(carFactory, new CarsValidator());

        RacingCarController racingCarController =
                new RacingCarController(new InputView(), new OutputView(), participantsFactory);
        racingCarController.run();
    }
}
