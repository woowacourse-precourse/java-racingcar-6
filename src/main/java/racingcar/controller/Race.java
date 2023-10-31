package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.Computer;
import racingcar.util.User;
import racingcar.view.Result;

public class Race {
    User user = new User();
    Computer computer = new Computer();
    List<Car> carList = new ArrayList<>();

    public void startRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        settingCar(user.inputCar());
        System.out.println("시도할 회수는 몇회인가요?");
        goCycle(user.inputTryNumber());
        Result.printWinner(carList);
    }

    public void goCycle(int cycle) {
        for (int i = 0; i < cycle; i++) {
            goForward();
            Result.printResult(carList);
        }
    }


    public boolean checkForward(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public void goForward() {
        for (Car car : carList) {
            if (checkForward(computer.getRandomNumber())) {
                car.addDistance();
            }
        }
    }

    public void settingCar(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName, 0);
            carList.add(car);
        }
    }
}
