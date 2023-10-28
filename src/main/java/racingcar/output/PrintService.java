package racingcar.output;

import java.util.List;
import racingcar.domain.Car;

public class PrintService {

    public static void inputCarNameRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askAttemtCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void show(Car car) {
        System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getStraightCount()));
    }

    public static void result(List<String> racings) {
        String winners = String.join(", ", racings);
        System.out.printf("최종 우승자 : %s", winners);
    }
    public static void nextLine() {
        System.out.println();
    }
}
