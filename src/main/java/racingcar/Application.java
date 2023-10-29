package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static List<String> inputCarNameList() {
        String[] stringArray = Console.readLine().split(",");
        return List.of(stringArray);
    }

    public static void main(String[] args) {
        List<String> carNameList = inputCarNameList();
    }
}
