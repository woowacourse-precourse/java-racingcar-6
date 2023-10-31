package controller;

import model.Car;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class UserController {
    private ArrayList<Car> racingCars;
    private int coin = 0;

    public UserController() {
        this.racingCars = new ArrayList<Car>();
    }

    public ArrayList<Car> getRacingCars() {
        return racingCars;
    }

    public int getCoin() {
        return coin;
    }

    public void intputUserValue() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        registerCar(userInput);

        System.out.println("시도할 회수는 몇회인가요?");
        String coinStr = Console.readLine();
        registerCoin(coinStr);
    }

    public void registerCar(String userInput) {
        int startNameIndex = 0;
        int size = userInput.length();

        for (int i = 0; i < size; i++) {
            if (userInput.charAt(i) == ',') {
                String carName = userInput.substring(startNameIndex, i);
                startNameIndex = i + 1;
                inputCarToList(carName);
            }
            if (i == size - 1) {
                String carName = userInput.substring(startNameIndex);
                inputCarToList(carName);
            }
        }
    }

    public void inputCarToList(String carName) {
        validateNameLength(carName);
        racingCars.add(new Car(carName));
    }

    public void validateNameLength(String carName) {
        if (carName.length() > 5) throw new IllegalArgumentException("이름은 5글자 이하로 입력해 주십시오.");
    }

    public void registerCoin(String coinStr) {
        this.coin = Integer.parseInt(coinStr);
    }
}
