package racingcar;

import java.util.HashMap;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static Map<String, Integer> getCarName(){
        Map<String, Integer> result = new HashMap<>();

        String carInput = Console.readLine();
        for(String name : carInput.split(",")) {
            result.put(name, 0);
        }

        return result;
    }

    public static int getGameRound(){
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
