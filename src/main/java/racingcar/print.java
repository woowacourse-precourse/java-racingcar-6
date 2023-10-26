package racingcar;

import java.util.List;

public class Print {
    public static void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void repetitions() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static void carStatus(Car car) {
        System.out.print(car.getName() + " : ");
        System.out.println("-".repeat(car.getPosition()));
    }

    public static void raceSituation(Race race) {
        List<Car> cars = race.getCars();
        for (Car car : cars) {
            carStatus(car);
        }
    }

    public static void winner(List<Car> winner) {
        List<String> winnerName = winner.stream()
                .map(Car::getName)
                .toList();
        System.out.println("최종 우승자 : " + String.join(", ", winnerName));
    }
}
