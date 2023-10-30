package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 입력받는 클래스
public class Input {
    public static Map<String, Integer> getInitialStatus() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = readLine().split(",");
        validateInput(cars);
        return Stream.of(cars).collect(Collectors.toMap(car -> car, car -> 0));
    }

    public static int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }

    public static void validateInput(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 넘습니다.");
            }
        }
    }
}