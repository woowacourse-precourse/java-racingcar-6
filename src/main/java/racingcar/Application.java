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
    }
}
