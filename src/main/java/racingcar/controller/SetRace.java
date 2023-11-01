package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.UserInput;

import java.util.ArrayList;
import java.util.List;

public class SetRace {
    private final List<Car> carsList = new ArrayList<>();

    public List<Car> createCar() {
        String input = UserInput.inputCarName();
        if (input.contains(",")) {
            String[] carNames = input.split(",");
            for (String carName : carNames) {
                if (carName.length() > 5) {
                    throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
                } else {
                    Car car = new Car(carName);
                    carsList.add(car);
                }
            }
        } else {
            throw new IllegalArgumentException("적어도 하나 이상의 자동차 이름을 입력해야 합니다.");
        }
        return carsList;
    }

    public int inputMovement() {
        try{
            return UserInput.inputMovementNumber();
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
