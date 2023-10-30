package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarData;
import racingcar.domain.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    static final int PASS_NUMBER = 4;
    static final int MOVING_FOWARD_NUMBER = 1;

    public static void startRacingCar() {
        OutputView.carNameInput();
        List<String> participantList = InputView.carName();
        OutputView.attemptCountInput();
        int attempt = InputView.attempt();
        OutputView.executionResultView();
        List<RacingCar> carList = RacingCarData.carData(participantList);
        do {
            playRacingCar(carList);
            attempt--;
        } while (attempt != 0);
    }

    public static void playRacingCar(List<RacingCar> carList) {

        for (int i = 0; i < carList.size(); i++) {
            int carId = i;
            int randomNumber = RandomNumber.randomNumber();
            RacingCar car = carList.get(i);

            if (randomNumber >= PASS_NUMBER) {
                car.moving(carId, MOVING_FOWARD_NUMBER);
            }

            String carName = car.getCarName(i);
            StringBuilder carPosition = RacingCarData.carPosition(i, car.getDistance(i));
            System.out.println(carName + " : " + carPosition);
        }

        OutputView.blankLine();

    }

}
