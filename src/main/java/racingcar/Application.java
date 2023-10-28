package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String userInput = inputCarName();
        List<String> deleteComma = deleteComma(userInput);
        System.out.println(deleteComma);
    }

    private static String inputCarName() {
        String inputCarName = Console.readLine();
        return inputCarName;
    }

    private static List<String> deleteComma(String inputCarName) {
        List<String> userCarName = new ArrayList<>();
        String[] userCarNameArr = inputCarName.split(",");
        for (String car : userCarNameArr) {
            userCarName.add(car.replace(",", ""));
        }
        return userCarName;
    }

    private static int inputTryCount() {
        int tryCount = Integer.parseInt(Console.readLine());
        return tryCount;
    }
}
