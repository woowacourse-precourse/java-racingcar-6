package racingcar.service;

import racingcar.dto.UserInput;
import racingcar.entity.Car;
import racingcar.util.NumberFactory;

import java.util.ArrayList;
import java.util.List;

// 게임을 진행하기 위한 클래스
public class GameService {
    public void processGame(UserInput userInput) {
        List<Car> carList = getCarList(userInput);

        for(int i = 0; i < userInput.frequency(); i++) {
            moveForward(carList);
        }
    }

    // 사용자가 입력한 값을 토대로 Car Entity List를 생성
    private List<Car> getCarList(UserInput userInput) {
        List<Car> carList = new ArrayList<>(userInput.frequency());

        String[] carNameArr = userInput.nameArr();

        for(String carName : carNameArr) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    // 임의의 값이 특정 조건을 만족하는 경우, 자동차의 위치를 이동
    private void moveForward(List<Car> carList) {
        for(Car car : carList) {
            int randomNumber = NumberFactory.getRandomNumber();
            car.moveForward(randomNumber);
        }
    }
}