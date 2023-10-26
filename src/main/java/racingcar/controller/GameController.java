package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class GameController {
    private Cars cars;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        initCars(input);
    }

    private void initCars(String input) {
        checkValidateInput(input);
        List<String> carNameList = splitCarNames(input);
        checkHasTwoOrMoreCarNames(carNameList);
        checkHasDuplicates(carNameList);
        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            Car car = new Car(name);
            carList.add(car);
        }

        cars = new Cars(carList);
    }

    private void checkValidateInput(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.trim().split(","));
    }

    private void checkHasTwoOrMoreCarNames(List<String> carNameList) {
        if (carNameList.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void checkHasDuplicates(List<String> carNameList) {
        boolean hasDuplicates = carNameList.stream()
                .anyMatch(name -> carNameList.indexOf(name) != carNameList.lastIndexOf(name));
        if (hasDuplicates) {
            throw new IllegalArgumentException();
        }
    }
}
