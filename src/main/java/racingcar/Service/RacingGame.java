package racingcar.Service;

import java.util.List;
import racingcar.Model.Car;
import racingcar.IO.Input;
import racingcar.IO.Output;

public class RacingGame {

    private List<Car> cars;
    private int attempts;

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = Input.getCars();

        System.out.println("시도할 회수는 몇회인가요?");
        attempts = Input.getAttempts();

        System.out.println();
    }

    public void gamePlay() {
        System.out.println("실행결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.moveCar();
            }
            System.out.println();
        }
    }

    public void gameEnd() {
        int longestDistance = getLongestDistance();

        String winners = Output.printWinners(cars, longestDistance);

        System.out.println("최종 우승자 : " + winners);
    }

    public int getLongestDistance() {
        return cars.stream()
                .mapToInt(Car::getLength)
                .max()
                .orElse(0);
    }
}
