package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RaceService {
    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_TRY_NUMBER = 1;

    private int tryCount;
    private int round = 0;
    public List<Car> getCarList(String carNames) {
        List<Car> carList = new ArrayList<>();

        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        List<String> addedCarNameList = new ArrayList<>();
        for (String carName : carNameList) {
            checkNameLength(carName);
            checkBlank(carName);
            isDuplicate(addedCarNameList, carName);
            Car car = new Car(carName);
            carList.add(car);
            addedCarNameList.add(carName);
        }
        return carList;
    }

    public void checkNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
        }
    }

    public void checkBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백은 입력할 수 없습니다.");
        }
    }

    public void isDuplicate(List<String> carList, String name) {
        if (carList.contains(name)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 이미 존재합니다.");
        }
    }

    public int getTryCount(String tryCountString) {
        tryCount = tryCountStringToInt(tryCountString);
        checkTryCount(tryCount);
        return tryCount;
    }

    public int tryCountStringToInt(String tryCountString) {
        try {
            return Integer.parseInt(tryCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

    public void checkTryCount(int count) {
        if (count < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("시도 횟수는 최소 1 이상의 수를 입력해야 합니다.");
        }
    }

    public void race(List<Car> carList) {
        round ++;
        for (Car car : carList) {
            car.move();
        }
    }

    public boolean isEnd() {
        if (round == tryCount) {
            return true;
        }
        return false;
    }

    public int getMaxPosition(List<Car> carList) {
        List<Integer> carPositions = new ArrayList<>();
        for (Car car : carList) {
            carPositions.add(car.getPosition());
        }
        return Collections.max(carPositions);
    }

    public List<String> getWinner(List<Car> carList) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == getMaxPosition(carList)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void printWinner(List<Car> carList) {
        List<String> winners = getWinner(carList);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
