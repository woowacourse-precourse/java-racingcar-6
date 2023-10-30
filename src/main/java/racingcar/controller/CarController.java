package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int forwardAttempt = 0;
        String inputCars = "";

        inputCars = input.promptForCarNames();
        Validate.inputIsNull(inputCars);

        cars = inputCarsStringToCarsClass(inputCars);

        forwardAttempt = inputForForward();

        output.resultHeader();

        // 전진 시도 횟수만큼 전진
        for(int forward = 0; forward < forwardAttempt; forward++) {
            // 각 자동차들 마다 forward()를 통하여 랜덤으로 생성한 값이 4 이상인 경우 전진
            cars.getCars()
                    .stream()
                    .forEach(car -> forward(car));
        }
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

    private int inputForForward() {
        String move  = input.promptForAttempts();
        Validate.inputIsNull(move);

        return forwardStringToInteger(move);
    }

    private int forwardStringToInteger(String move) {
        int result = 0;

        result = Validate.forwardIsNumericAndReturnInteger(move);
        Validate.forwardIsPositiveNumber(result);

        return result;
    }

    private void forward(Car car) {
        int randomValue = Randoms.pickNumberInRange(1, 9);
        if (randomValue >= 4) {
            car.forward();
        }
    }
}
