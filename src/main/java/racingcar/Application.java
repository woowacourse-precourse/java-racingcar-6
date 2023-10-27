package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] nameInput = readNames();
        List<Car> carList = Arrays.stream(nameInput)
                .map(Car::new)
                .toList();

        Cars cars = new Cars(carList);

        System.out.println("시도할 회수는 몇회인가요?");
        int raceCount = readCount();

        System.out.println("\n실행 결과");
        for (int i = 0; i < raceCount; i++) {
            cars.calculateMoveCount();
            System.out.println();
        }
    }

    private static int readCount() {
        return Integer.parseInt(Console.readLine());
    }

    private static String[] readNames() {
        return Console.readLine().split(",");
    }
}


