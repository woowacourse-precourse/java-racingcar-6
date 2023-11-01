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
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;
    private final int MOVING_MIN_NUMBER = 4;

    public RacingCarService(CarList carList, RacingCarValidation racingCarValidation) {
        this.carList = carList;
        this.racingCarValidation = racingCarValidation;
    }

    public CarList createCarList() {
        List<String> nameList = Arrays.stream(readLine().split(",")).toList();

        return createCarAddList(nameList);
    }

    public CarList createCarAddList(List<String> nameList) {
        for (String name : nameList) {
            checkNameValidation(name);
            carList.addCarList(new Car(name));
        }
        return carList;
    }

    public int readCount() {
        String countString = readLine();
        return checkCountValidation(countString);
    }

    public CarList checkCarListMove() {
        for (Car car : carList.getCarList()) {
            checkMoving(car);
        }
        return carList;
    }

    public void checkMoving(Car car) {
        int excel = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (excel >= MOVING_MIN_NUMBER)
            car.move();
    }

    public List<String> getWinner() {
        int winnerLocation = carList.getRacingCarWinnerLocation();

        return carList.getRacingCarWinnerName(winnerLocation);
    }

    private void checkNameValidation(String name) {
        racingCarValidation.checkNameBlank(name);
        racingCarValidation.checkNameLength(name);
        racingCarValidation.checkDuplicateName(carList, name);
    }

    private int checkCountValidation(String countString) {
        racingCarValidation.checkCountDigit(countString);
        return racingCarValidation.illegalValidation(Integer.parseInt(countString));
    }

}