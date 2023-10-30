package racingcar.service;

import racingcar.dto.UserInput;
import racingcar.entity.Car;
import racingcar.util.NumberFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.GameDefaultMessage.*;

// 게임을 진행하기 위한 클래스
public class GameService {
    private final StringBuilder sb = new StringBuilder();

    public String processGame(UserInput userInput) {
        List<Car> carList = getCarList(userInput);

        for(int i = 0; i < userInput.frequency(); i++) {
            moveForward(carList);
            printGameResult(carList);
        }

        int maxValue = getMaxValue(carList);

        String winnerName = getWinnerName(carList, maxValue);

        sb.append(MESSAGE_GAME_WINNER).append(winnerName).append("\n");

        return sb.toString();
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

    // 게임을 진행 결과를 출력
    private void printGameResult(List<Car> carList) {
        sb.append(MESSAGE_GAME_RESULT).append("\n");

        for(Car car : carList) {
            sb.append(car).append("\n");
        }

        sb.append("\n");
    }

    // 가장 멀리 간 자동차의 위치를 반환
    private int getMaxValue(List<Car> carList) {
        return carList.stream()
                .map(Car::getLocation)
                .max(Integer::compare).get();
    }

    // 우승한 자동차의 이름을 반환, 우승한 자동차가 여러 대 존재하는 경우 ','를 통해 여러 대의 자동차 이름을 반환
    private String getWinnerName(List<Car> carList, int maxValue) {
        return carList.stream().filter(car -> car.getLocation() == maxValue)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }
}