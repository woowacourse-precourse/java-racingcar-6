package racingcar.service;


import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.validation.RacingCarValidation;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

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

    public int readCount() {
        int count = Integer.parseInt(readLine());
        return racingCarValidation.illegalValidation(count);
    }

    public CarList checkCarListMove() {
        for (Car car : carList.getCarList()) {
            checkMoving(car);
        }
        return carList;
    }

    public void checkMoving(Car car) {
        int excel = pickNumberInRange(0, 9);
        if (excel >= 4)
            car.move();
    }

    public List<String> getWinner() {
        int winnerLocation = carList.getRacingCarWinnerLocation();

        return carList.getRacingCarWinnerName(winnerLocation);
    }
}