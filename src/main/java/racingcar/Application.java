package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(saveCarName(getCarNames()));

    }

    public static void printInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static String getCarNames() {
        printInputCarName();
        String input = Console.readLine();
        return input;
    }
    public static List<String> saveCarName(String names) {
        List<String> carNames = Arrays.asList(names.split(","));
        return carNames;
    }
}
