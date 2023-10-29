package controller;

import repository.CarListRepository;
import service.RandomMovementDecider;
import view.InputView;

import static service.RandomMovementDecider.decideForwardMovement;

public class RacingGame {
    public void gameStart() {
        CarListRepository carListRepository = new CarListRepository();
        carListRepository.setCarListRepository(InputView.setCarNames());

        int tryNumber = Integer.parseInt(InputView.setTryNumber());
        for (int Try = 0; Try < tryNumber; Try++) {
            decideForwardMovement(carListRepository);
        }
    }

}
