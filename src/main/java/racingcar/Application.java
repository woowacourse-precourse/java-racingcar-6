package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }
    public static List<String> scanCarName() {
        String carNames = Console.readLine();
        if (!carNames.matches("^([a-z,A-Z,가-힣])*$")) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(carNames.split(",")).toList();
    }
}
