package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.NoSuchElementException;

public class RacingCarConsole {
    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            return Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException("자동차의 이름을 정해주세요.");
        }
    }

    public static int readIterationNumBer() {
        System.out.println("시도할 회수는 몇회인가요?");

        String iterationNumBer;
        try {
            iterationNumBer = Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException("시도 회수를 정해주세요.");
        }

        try {
            return Integer.parseInt(iterationNumBer);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("시도 회수는 숫자로 입력해주세요.");
        }
    }

    public static void printCarRacingProgressState(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public static void printChampionCars(List<Car> championCars) {
        List<String> championCarsName = championCars.stream().map(Car::getName).toList();
        String championCarsMessage = championCarsName.stream()
                .reduce((carNames, carName) -> carNames + ", " + carName)
                .get();

        System.out.println("최종 우승자 : " + championCarsMessage);
    }
}
