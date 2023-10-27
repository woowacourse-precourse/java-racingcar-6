package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;
import racingcar.model.Cars;

public class GameController {
    private Cars cars;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesInput = Console.readLine();
        initCars(namesInput);
    }

    private void initCars(String input) {
        checkValidateInput(input);
        List<String> carNameList = splitCarNames(input);
        checkHasTwoOrMoreCarNames(carNameList);
        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            Car car = new Car(name);
            carList.add(car);
        }

        cars = new Cars(carList);
    }

    private void checkValidateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.trim().split(","));
    }

    private void checkHasTwoOrMoreCarNames(List<String> carNameList) {
        checkHasDuplicates(carNameList);
        if (carNameList.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void checkHasDuplicates(List<String> carNameList) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNameList) {
            if (!uniqueNames.add(name.trim())) {
                throw new IllegalArgumentException();
            }
        }
    }
}
