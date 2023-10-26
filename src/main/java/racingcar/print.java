package racingcar;

import java.util.List;

class Print {
    static void startString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static void repetitionsString() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static void carStatus(Car car) {
        System.out.print(car.getName() + " : ");
        System.out.println("-".repeat(car.getPosition()));
    }

    static void raceSituation(Race race) {
        List<Car> cars = race.getCars();
        for (Car car : cars) {
            carStatus(car);
        }
    }

    static void winner(List<Car> winner) {
        List<String> winnerName = winner.stream()
                .map(Car::getName)
                .toList();
        System.out.println("최종 우승자 : " + String.join(", ", winnerName));
    }
}
