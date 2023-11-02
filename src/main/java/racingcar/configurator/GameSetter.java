package racingcar.configurator;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.UserView;

public class GameSetter {
    static final int NAME_LENGTH_LIMIT = 5;

    private final Cars carList;
    private final UserView userView;

    private String userInputValue;
    private int coin;

    public GameSetter(Cars carList) {
        this.carList = carList;
        this.userView = new UserView();

        this.userInputValue = userView.inputNameValue();
        this.coin = userView.inputCoinValue();
    }

    public GameSetter(Cars carList, String inputValue, int coinValue){
        this.carList = carList;
        this.userView = new UserView();

        this.userInputValue = inputValue;
        this.coin = coinValue;
    }

    public void registerCars() {
        int startNameIndex = 0;
        int length = userInputValue.length();

        for (int i = 0; i < length; i++) {
            if (userInputValue.charAt(i) == ',') {
                String carName = userInputValue.substring(startNameIndex, i);
                startNameIndex = i + 1;
                inputCarToList(carName);
            }
            if (i == length - 1) {
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
