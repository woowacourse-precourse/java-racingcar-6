package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars = new ArrayList<>();
    private final int attempts;

    public RacingGame(String carNames, int attempts) {
        validateCarNames(carNames);
        this.attempts = attempts;
        initializeCars(carNames);
    }

    private void initializeCars(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    public void run() {
        Race race = new Race(cars, attempts);
        System.out.println("\n실행 결과");
        race.start();
        printWinners(race.getWinners());
    }

    private void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private void validateCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + name.trim());
            }
        }
    }
}
