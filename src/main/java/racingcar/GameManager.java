package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;

public class GameManager {

    public static void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameInput = Console.readLine();
        Cars cars = GameUtil.inputToCars(nameInput);

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());
        racing(cars, count);
        printWinner(cars);
    }

    public static void racing(Cars cars, int count) {
        IntStream.range(0, count).forEach(i -> {
            cars.movePosition();
            printRacingResult(cars);
        });
    }

    public static void printRacingResult(Cars cars) {
        cars.carList.forEach(car -> {
            System.out.println(car.getInfo());
        });

        System.out.println();
    }

    public static void printWinner(Cars cars) {
        List<Car> winner = cars.getWinner();
        System.out.print("최종 우승자 : ");

        StringBuilder sb = new StringBuilder();
        winner.forEach(car -> sb.append(car.getName()).append(", "));
        sb.delete(sb.length() - 2, sb.length());

        System.out.print(sb);
    }
}
