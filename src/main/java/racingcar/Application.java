package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        int tries = Integer.parseInt(Console.readLine());

        RacingGame game = new RacingGame(carNames);
        System.out.println("\n실행 결과");
        for (int i = 0; i < tries; i++) {
            game.race();
            displayCars(game.getCars());
            System.out.println();
        }

        System.out.println("최종 우승자 : " + getWinners(game.getCars()));
    }

    private static void displayCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static String getWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");
    }
}
