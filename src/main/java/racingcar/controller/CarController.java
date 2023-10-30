package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Cars;
import racingcar.model.Car;
import racingcar.util.Validate;
import racingcar.view.Input;
import racingcar.view.Output;

public class CarController {
    private static final String delimiter = ",";
    private Input input;
    private Output output;
    private Cars cars;

    public CarController() {
        this.input = new Input();
        this.output = new Output();
    }

    public void racing() {
        String inputCars = "";

        inputCars = input.promptForCarNames();
        Validate.inputIsNull(inputCars);

        cars = inputCarsStringToCarsClass(inputCars);
    }

    private Cars inputCarsStringToCarsClass(String inputTemp) {
        List<String> carList = new ArrayList<>();

        Validate.inputStringNotContainsComma(inputTemp);
        Validate.lastCharIsComma(inputTemp); // 구분자 뒤 자동치 이름이 없는 경우 유효성 검사
        carList = splitCarNamesReturnList(inputTemp); // , 를 기준으로 구분하여 List<String> 생성

        Validate.carNameIsOne(carList);

        return listToCarModel(carList);
    }

    private Cars listToCarModel(List<String> carList) {
        List<Car> cars = new ArrayList<>();

        for(String name: carList) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    private List<String> splitCarNamesReturnList(String carMembers) {
        return Arrays.asList(carMembers.split(delimiter));
    }

}
