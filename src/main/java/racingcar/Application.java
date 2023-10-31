package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.factory.CarFactory;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.CarsValidator;
import racingcar.domain.factory.ParticipantsFactory;
import racingcar.domain.RandomMoveEngine;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarFactory carFactory = getCarFactory();
        ParticipantsFactory participantsFactory = getParticipantsFactory(carFactory);
        RacingCarController racingCarController = getController(participantsFactory);

        racingCarController.run();
    }

    private static CarFactory getCarFactory() {
        return new CarFactory(new RandomMoveEngine(), new CarNameValidator());
    }

    private static ParticipantsFactory getParticipantsFactory(CarFactory carFactory) {
        return new ParticipantsFactory(carFactory, new CarsValidator());
    }

    private static RacingCarController getController(ParticipantsFactory participantsFactory) {
        return new RacingCarController(new InputView(), new OutputView(), participantsFactory);
    }
}
