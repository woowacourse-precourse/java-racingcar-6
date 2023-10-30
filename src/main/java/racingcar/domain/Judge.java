package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.InputHandler;
import racingcar.Validator;

public class Judge {
    private List<Car> cars;
    private int numberOfAttempts;

    public Judge() {
        this.cars = new ArrayList<>();
    }

    private String[] makeCarNamesArray() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNamesArray = InputHandler.inputCarNames();
        Validator.checkValidCarNames(carNamesArray);
        return carNamesArray;
    }

    private void makeNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = InputHandler.inputNumberOfAttempts();
        Validator.isValidNumberOfAttempts(numberOfAttempts);
        this.numberOfAttempts = numberOfAttempts;
    }

    public void setCars(String[] carNamesWithStringArray) {
        for (String carName : carNamesWithStringArray) {
            cars.add(new Car(carName));
        }
    }

    protected List<Car> getCars() {
        return cars;
    }
}
