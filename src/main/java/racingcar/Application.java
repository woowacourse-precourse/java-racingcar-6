package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    final static int CHARACTERS_LIMIT = 5;
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 기능 1.
        List<String> cars = Arrays.stream(Console.readLine().split(",")).toList();
        boolean anyNameExceedsCharactersLimit = cars.stream().anyMatch(car->car.length() > CHARACTERS_LIMIT);
        if(anyNameExceedsCharactersLimit) {
            throw new IllegalArgumentException(String.format("이름은 %d자를 넘지 못합니다.", CHARACTERS_LIMIT));
        }



    }
}
