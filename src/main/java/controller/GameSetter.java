package controller;

import model.Car;
import model.CarList;
import view.UserView;

public class RacingGame {
    private final CarList carList;
    private final UserView userView;

    private String inputValue;
    private int coinValue;
    public RacingGame(CarList carList) {
        this.carList = carList;
        this.userView = new UserView();
    }

    public void setGame(){
        this.inputValue = userView.inputNameValue();
        this.coinValue = userView.inputCoinValue();
    }

    public void registerCars() {
        int startNameIndex = 0;
        int size = inputValue.length();

        for (int i = 0; i < size; i++) {
            if (inputValue.charAt(i) == ',') {
                String carName = inputValue.substring(startNameIndex, i);
                startNameIndex = i + 1;
                inputCarToList(carName);
            }
            if (i == size - 1) {
                String carName = inputValue.substring(startNameIndex);
                inputCarToList(carName);
            }
        }
    }

    public void inputCarToList(String carName) {
        validateNameLength(carName);
        carList.addCar(new Car(carName));
    }

    public void validateNameLength(String carName) {
        if (carName.length() > 5) throw new IllegalArgumentException("이름은 5글자 이하로 입력해 주십시오.");
    }

    int getCoin(){
        return this.coinValue;
    }
}
