package racingcar.service;


import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.validation.RacingCarValidation;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarService {


    private final CarList carList;
    private final RacingCarValidation racingCarValidation;

    public RacingCarService(CarList carList, RacingCarValidation racingCarValidation) {
        this.carList = carList;
        this.racingCarValidation = racingCarValidation;
    }

    public void createCarList() {
        List<String> nameList = Arrays.stream(readLine().split(",")).toList();

        createCarAddList(nameList);
    }

    public void createCarAddList(List<String> nameList) {
        for (String name : nameList) {
            racingCarValidation.checkNameLength(name);
            racingCarValidation.checkDuplicateName(carList, name);
            carList.addCarList(new Car(name));
        }
    }

}