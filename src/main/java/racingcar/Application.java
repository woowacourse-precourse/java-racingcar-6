package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        racingGame();
    }

    private static void racingGame() {
        String userInput = inputCarName();
        int tryCount = inputTryCount();

        HashMap<String, String> userCarNameAndMoveStatus = userCarNameSave(userInput);

        for (int i = 0; i < tryCount; i++) {
            referee(userCarNameAndMoveStatus);
            moveStatus(userCarNameAndMoveStatus);
        }
    }

    private static void moveStatus(HashMap<String, String> referee) {
        for (String userCarName : referee.keySet()) {
            String userCarMoveResult = referee.get(userCarName);
            System.out.println(userCarName + " : " + userCarMoveResult);
        }
        System.out.println();
    }

    private static HashMap<String, String> referee(HashMap<String, String> createUserCar) {
        for (String key : createUserCar.keySet()) {
            String value = createUserCar.get(key);
            if (randomNumber() >= 4) {
                createUserCar.put(key, value + "-");
            }
        }
        return createUserCar;
    }

    private static HashMap<String, String> userCarNameSave(String inputCarName) {
        HashMap<String, String> createUserCar = new HashMap<>();
        String[] userCarNameArr = inputCarName.split(",");
        for (String car : userCarNameArr) {
            createUserCar.put(car, "");
        }
        return createUserCar;
    }

    private static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();
        return inputCarName;
    }

    private static int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        return tryCount;
    }

    private static int randomNumber() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random;
    }

}
