package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Car> cars;
    private final int attempts;

    public Game(String carNames, String attempts) {
        this.cars = new ArrayList<>();
        String[] splitNames = carNames.split(",");
        for (String name : splitNames) {
            cars.add(new Car(name));
        }

        try {
            this.attempts = Integer.parseInt(attempts);
            if (this.attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력되어야 합니다.");
        }
    }

    public void race() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                int num = Randoms.pickNumberInRange(0, 9);
                car.move(num);
            }
            printRaceStatus();
        }
        printWinner();
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public String printWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        String winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winners);
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }
}
