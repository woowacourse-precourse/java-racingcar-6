package racingcar.service;

import racingcar.util.OutputManager;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;


public class Race {

    private final List<Car> cars;
    private final int trials;
    private final List<Car> winners;

    public Race(List<Car> cars, int trials) {
        this.cars = cars;
        this.trials = trials;
        this.winners = new ArrayList<>();
    }

    // 경기 실행. 각 자동차에게 움직일 수 있는 기회 부여 후 결과 출력
    // 경기 종료 후 승자 판별 실행
    public void executeRace() {
        OutputManager.displayRaceHeader();

        for (int i = 0; i < trials; i++) {
            for (Car car : cars) {
                car.move();
                OutputManager.displayCarPosition(car);
            }
            OutputManager.displayBlankLine();
        }
        determineWinners();
    }

    // 가장 앞서 있는 차량 기준 승자 판별
    private void determineWinners() {
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
    }

    // 가장 앞서 있는 차량의 위치 판별
    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners() {
        return winners;
    }

}
