package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();

        Map<String, Integer> carMap = Stream.of(carNames.split(","))
                .collect(Collectors.toMap(carName -> carName, score -> 0));
        System.out.println(carMap);

        System.out.println("시도할 회수는 몇회인가요?");

        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
            if (tryCount < 1) {
                throw new IllegalArgumentException("시도할 회수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수로 숫자를 입력해주세요.");
        }
    }
}