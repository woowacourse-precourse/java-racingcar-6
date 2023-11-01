package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.service.CarService;

import java.util.ArrayList;
import java.util.List;

import static racingcar.common.InputException.*;

public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public void startRacingGame() {
        String[] carNames = getCarNames();

        List<Car> carsList = carsToList(carNames);

        int count = getTryCount();

        carService.playGame(carsList, count);
    }

    private int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = Console.readLine();
        tryCountValidate(tryCount);

        return Integer.parseInt(tryCount);
    }

    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        carNameValidate(carNames);
        return carNames;
    }

    private static ArrayList<Car> carsToList(String[] carNames) {
        ArrayList<Car> carsList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            Car car = new Car(carNames[i], 0);
            carsList.add(car);
        }
        return carsList;
    }
}
