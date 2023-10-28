package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String userInput = inputCarName();
        int tryCount = inputTryCount();
        int randomNumber = randomNumber();

        List<String> userCarList = deleteComma(userInput);


    }

    private static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
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
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        return tryCount;
    }

    private static int randomNumber() {
        int random = Randoms.pickNumberInRange(0,9);
        return random;
    }

    private static String moveForward() {
        return "-";
    }

    private static String moveStop() {
        return "";
    }
}
