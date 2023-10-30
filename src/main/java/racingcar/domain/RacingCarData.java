package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarData {

    static final int PASS_NUMBER = 4;
    static final int MOVING_FORWARD_NUMBER = 1;
    public static List<RacingCar> carData(List<String> carNameList) {

        List<RacingCar> carData = new ArrayList<>();

        for (int i = 0; i < carNameList.size(); i++) {
            RacingCar racingCar = new RacingCar();
            racingCar.carDataSave(i, carNameList.get(i));
            carData.add(racingCar);
        }

        return carData;
    }

    public static StringBuilder carPosition(int id, int position) {

        RacingCar car = new RacingCar();

        StringBuilder carPosition = new StringBuilder();

        for (int i = 0; i < position; i++) {
            carPosition.append("-");
        }

        return carPosition;

    }

    public static void RacingCarResult(List<RacingCar> carList) {

        for (int i = 0; i < carList.size(); i++) {
            int carId = i;
            int randomNumber = RandomNumber.randomNumber();
            RacingCar car = carList.get(i);

            if (randomNumber >= PASS_NUMBER) {
                car.moving(carId, MOVING_FORWARD_NUMBER);
            }

            String carName = car.getCarName(i);
            StringBuilder carPosition = RacingCarData.carPosition(i, car.getDistance(i));
            System.out.print(carName);
            OutputView.colon();
            System.out.println(carPosition);
        }

        OutputView.blankLine();
    }

}
