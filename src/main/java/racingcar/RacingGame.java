package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private int attempts;

    public void initializeGame() {
        this.cars = initializeCars();
        this.attempts = initializeAttempts();
    }

    private List<Car> initializeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return CarFactory.createCars(input);
    }

    private int initializeAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void playGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.attemptToMove(Randoms.pickNumberInRange(0, 9));
            System.out.println(car);
        }
        System.out.println();
    }

    public void announceWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        String winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winners);
    }
}