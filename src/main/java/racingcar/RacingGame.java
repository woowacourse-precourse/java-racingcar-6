package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void play(int rounds) {
        for (int round = 0; round < rounds; round++) {
            System.out.println("\n" + "Round " + (round + 1) + ":");
            moveCars();
            printCarStatus();
        }
        printWinners();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printCarStatus() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private void printWinners() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(Console.readLine());

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.play(rounds);
    }
}

