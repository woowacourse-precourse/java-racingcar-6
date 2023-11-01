package racingcar.configurator;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.UserView;

public class GameSetter {
    static final int NAME_LENGTH_LIMIT = 5;

    private final CarList carList;
    private final UserView userView;

    private String userInputValue;
    private int coin;

    public GameSetter(CarList carList) {
        this.carList = carList;
        this.userView = new UserView();

        this.userInputValue = userView.inputNameValue();
        this.coin = userView.inputCoinValue();
    }

    public void registerCars() {
        int startNameIndex = 0;
        int size = userInputValue.length();

        for (int i = 0; i < size; i++) {
            if (userInputValue.charAt(i) == ',') {
                String carName = userInputValue.substring(startNameIndex, i);
                startNameIndex = i + 1;
                inputCarToList(carName);
            }
            if (i == size - 1) {
                String carName = userInputValue.substring(startNameIndex);
                inputCarToList(carName);
            }
        }
    }

    public void inputCarToList(String carName) {
        validateNameLength(carName);
        carList.addCar(new Car(carName));
    }

    public void validateNameLength(String carName) {
        if (carName.length() > NAME_LENGTH_LIMIT) throw new IllegalArgumentException("이름은 5글자 이하로 입력해 주십시오.");
    }

    public int getCoin() {
        return coin;
    }
}
