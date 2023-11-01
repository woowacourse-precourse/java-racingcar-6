package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class GameService {
    // 게임을 진행하는 메서드
    public List<String> playGame(List<Car> cars, int rounds) {
        List<String> gameResults = new ArrayList<>();

        for (int round = 0; round < rounds; round++) {
            moveCars(cars);
            List<Car> roundWinners = determineRoundWinners(cars);
            String roundResult = OutputView.getRoundResults(cars);
            gameResults.add(roundResult);
            if (roundWinners.size() == cars.size()) {
                gameResults.add("최종 우승자: " + String.join(", ", determineGameWinners(cars)));
                break;
            }
        }

        return gameResults;
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generate());
        }
    }

    public List<Car> determineRoundWinners(List<Car> cars) {
        return cars;
    }

    public List<String> determineGameWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> gameWinners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                gameWinners.add(car.getName());
            }
        }
        return gameWinners;
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
