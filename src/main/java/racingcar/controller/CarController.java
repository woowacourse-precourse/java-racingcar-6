package racingcar.controller;

import static racingcar.common.Config.*;
import static racingcar.model.CarNameList.*;
import static racingcar.model.CountCarMovement.*;
import static racingcar.model.RandomNumbers.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarNameList;
import racingcar.model.CountCarMovement;

public class CarController {
    private final CarNameList carNameList;
    private final CountCarMovement countCarMovement;

    private CarController(List<String> carStringList) {
        this.countCarMovement = createCountCarMovement(carStringList.size());
        this.carNameList = createCar(carStringList);
    }

    public static CarController createCars(List<String> carStringList) {
        return new CarController(carStringList);
    }

    public void ifForwardCars() {
        List<Boolean> resultRandomNumbers = createRandomNumbers(carNameList.countCar())
                .getRandomNumberList();

        for (int i = 0; i < resultRandomNumbers.size(); i++) {
            if(resultRandomNumbers.get(i)) {
                countCarMovement.forwardCar(i);
            }
        }
    }

    public String chooseWinner() {
        List<String> winnersName = new ArrayList<>();

        for (Integer index : countCarMovement.winnersIndex()) {
            winnersName.add(carNameList.toString(index));
        }

        return String.join(", ", winnersName);
    }

    public String toString() {
        StringBuilder carsMessage = new StringBuilder();

        for (int i = 0; i < carNameList.countCar(); i++) {
            carsMessage.append(
                    String.format(
                            EACH_RACER_RESULT,
                            carNameList.toString(i),
                            countCarMovement.toString(i)));
        }

        return carsMessage.toString();
    }
}
