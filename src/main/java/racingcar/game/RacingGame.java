package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.components.Car;
import racingcar.support.ResultPrinter;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final ResultPrinter resultPrinter = new ResultPrinter();

    public void execute(List<Car> cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            moveCars(cars);
            resultPrinter.execute(cars);
        }
        List<Car> result = result(cars);
        resultPrinter.winner(result);
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (isMovable()) {
                car.move();
            }
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    /**
     * 최종 승리자를 판단
     *
     * @param cars 게임에 참여한 모든 자동차
     * @return 최종 승리자를 담은 List
     */
    private List<Car> result(List<Car> cars) {

        //List 내부에서 전진 거리의 최대값을 추출
        int maxValue = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException());

        //전진 거리의 최대값을 가지고 있는 car 객체만 추출
        List<Car> winners = cars.stream()
                .filter(car -> car.getDistance() == maxValue)
                .collect(Collectors.toList());

        return winners;
    }
}
