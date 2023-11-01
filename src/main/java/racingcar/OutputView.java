package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";

    public static void printInputCarNameMessage(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }
    public static void printInputTryNumber() {
        System.out.println(INPUT_TRY_NUMBER);
    }
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.displayDistance());
        }
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        List<String> winners = cars.stream().filter(car -> car.getDistance() == maxDistance).map(Car::getName).collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}