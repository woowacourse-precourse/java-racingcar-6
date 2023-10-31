package racingcar.domain;

import java.util.List;
import java.util.stream.Stream;

public class RacingCarGame {

    private final List<Car> cars;

    private final Referee referee = new Referee();
    private final int tryNum;

    public RacingCarGame(List<Car> cars, int tryNum) {
        this.cars = cars;
        this.tryNum = tryNum;
    }

    // 정적 생성 메서드
    public static RacingCarGame create(String carNames, String tryNum) {

        List<Car> cars = Stream.of(carNames.split(","))
                .map(Car::new)
                .toList();

        return new RacingCarGame(cars, Integer.parseInt(tryNum));
    }

    public void play() {
        for (int i = 0; i < tryNum; i++) {
            carsTryMove();
        }
    }

    public String getResult() {
        return referee.selectWinner(cars);
    }

    private void carsTryMove() {

        for (Car car : cars) {
            boolean isMoveCondition = car.isMoveCondition();
            car.move(isMoveCondition);
        }

        System.out.println();
    }
}