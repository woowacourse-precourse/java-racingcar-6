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

        for (int round = 0; round < rounds; round++){
            // 각 라운드를 실행하고 자동차를 전진시키는 로직 구현
            moveCars(cars);
            List<Car> roundWinners = determineRoundWinners(cars);
            String roundResult = OutputView.getRoundResults(cars);
            gameResults.add(roundResult);
            if (roundWinners.size() == cars.size()) {
                gameResults.add("최종 우승자: " + String.join(", ", determineGameWinners(cars)));
                break;
            }
        }
        // 최종 승자를 결정하는 로직
        return gameResults;
    }

    // 자동차를 전진시키는 메서드 -> 자동차의 위치 업데이트시킴
    public void moveCars(List<Car> cars) {
        // 각 자동차를 전진
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generate());
        }
    }

    // 라운드에서 승자를 판별하는 메서드로 라운드에서 가장 멀리 이동한 자동차를 판별
    public List<Car> determineRoundWinners(List<Car> cars) {
        // 라운드에서 승자를 판별하는 로직 구현
        return cars;
    }

    // 최종 승자를 결정하는 메서드
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

    // 최대 위치를 찾는 메서드
    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    // 각 차수별 실행 결과를 문자열로 출력하는 메서드
    public static String printRoundResults(List<Car> cars) {
        StringBuilder roundResult = new StringBuilder();
        for (Car car : cars) {
            roundResult.append(car.getName()).append(" : ").append(car.getPositionBar()).append("\n");
        }
        return roundResult.toString();
    }

    // 필요 기능 추가

}
