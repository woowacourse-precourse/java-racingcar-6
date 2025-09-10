package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> carList;
    private final static Integer GO_CONDITION = 4;
    private final static Integer RANDOM_NUMBER_MIN = 0;
    private final static Integer RANDOM_NUMBER_MAX = 9;


    public Race() {
        this.carList = new ArrayList<>();
    }

    public void registerCars(List<Car> newCarList) {
        carList.addAll(newCarList);
    }

    public void playRace() {
        for (Car car : carList) {
            if (canAdvance()) {
                car.advance();
            }
        }
    }

    private boolean canAdvance() {
        int randomValue = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        return randomValue >= GO_CONDITION;
    }

    public void printCurrentStatus() {
        System.out.println("실행 결과");
        for (Car car : carList) {
            System.out.print(car);
        }
        System.out.println();
    }

    public List<Car> getWinners() {
        int maxDistance = 0;
        for (Car car : carList) {
            maxDistance = car.updateMaxDistance(maxDistance);
        }
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.isAtMaxDistance(maxDistance)) {
                winners.add(car);
            }
        }
        return winners;
    }
}
