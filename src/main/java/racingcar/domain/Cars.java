package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void add(String name) {
        cars.add(new Car(name));
    }

    public void racing() {
        for (Car car : cars) {
            car.race(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Car> giveCopiedResult() { //원본 리스트 요소에 영향 없게 반환
        List<Car> copiedResult = new ArrayList<>();
        for (Car car : cars) {
            Car copiedCar = new Car(car.getName(), car.getMovement());
            copiedResult.add(copiedCar);
        }
        return copiedResult;
    }

    public int maxMovement() {
        int maxValue = 0;
        for (Car car : cars) {
            maxValue = Math.max(maxValue, car.getMovement());
        }
        return maxValue;
    }

    public String findWinner() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMovement() == maxMovement()) {
                winnerList.add(car.getName());
            }
        }
        String winner = String.join(",", winnerList);
        return winner;
    }

    public List<Car> getCars() {//테스트 코드용
        return cars;
    }
}
