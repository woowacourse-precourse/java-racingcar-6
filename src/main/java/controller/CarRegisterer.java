package controller;

import model.Car;
import model.CarList;
import view.UserView;

public class CarRegisterer {
    private final CarList carList;
    private final UserView userView;

    private String userInputValue;

    public CarRegisterer(CarList carList) {
        this.carList = carList;
        this.userView = new UserView();

        this.userInputValue = userView.inputNameValue();
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
        if (carName.length() > 5) throw new IllegalArgumentException("이름은 5글자 이하로 입력해 주십시오.");
    }
}
