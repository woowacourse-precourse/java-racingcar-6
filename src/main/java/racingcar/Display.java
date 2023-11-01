package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.Utils.makeLane;

public class Display {

    static List<Car> inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String[] inputs = Console.readLine().split(",");
            return Arrays.stream(inputs).map(Car::new).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static int inputTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static void printCurrentPositions(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + makeLane(car.getPosition()));
        }
        System.out.println();
    }

    static void printFinalWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
