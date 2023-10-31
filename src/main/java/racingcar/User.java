package racingcar;

import java.util.ArrayList;
import java.util.List;

public class User {
    GameUI gameUI = new GameUI();
    private List<Car> carList = new ArrayList<>();

    public void makeCars(String inputStr) {
        String[] carNameTempArr = splitByComma(inputStr);
        for (int i = 0; i < carNameTempArr.length; i++) {
            String carName = carNameTempArr[i];
            appendCar(carName);
        }
    }

    private static String[] splitByComma(String inputStr) {
        String[] carNameTempArr = inputStr.split(",");
        return carNameTempArr;
    }

    // 자동차 이름의 길이가 5와 같거나 작으면 carList에 추가
    private void appendCar(String carName) {
        if (carName.length() <= 5) {
            carList.add(new Car(carName));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void tryDriving(int attemptNum) {
        for (int i = 0; i < attemptNum; i++) {
            drivingEachCar();
            // 각각의 자동차를 한 번씩 출력하면 줄바꿈
            gameUI.printNewLine();
        }
    }

    private void drivingEachCar() {
        for (Car car : carList) {
            car.driving();
            gameUI.printCarDistance(car);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
