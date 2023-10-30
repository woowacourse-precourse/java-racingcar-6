package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String inputNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputNames.split(","));
//      List<String> carNames = Arrays.asList(Console.readLine().split(","));

        int tryCount = Integer.parseInt(Console.readLine());


    }
}
