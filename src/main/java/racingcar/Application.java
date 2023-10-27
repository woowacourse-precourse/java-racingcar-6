package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Application T = new Application();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String racingCar = Console.readLine();
        List<String> racingCarName = T.listConversion(racingCar);

        System.out.println("시도할 회수는 몇회인가요?");
        String gameNumString = Console.readLine();

        if (!isValidNum(gameNumString)) {
            throw new IllegalArgumentException("올바른 회수 입력이 아닙니다.");
        }
    }

    public static List<String> listConversion(String racingCar) throws IllegalArgumentException {
        List<String> racer = new ArrayList<String>();
        String[] splitStr = racingCar.split(",");

        for (int i = 0; i < splitStr.length; i++) {
            racer.add(splitStr[i]);

            if (!isValidName(splitStr[i]))
                throw new IllegalArgumentException("올바른 자동차 이름이 아닙니다.");
        }

        return racer;
    }

    public static boolean isValidName(String splitStr) {
        if (splitStr.length() > 5)
                return false;

        return true;
    }

    public static boolean isValidNum(String gameNumString) {
        for (int i = 0; i < gameNumString.length(); i++) {
            if (!Character.isDigit(gameNumString.charAt(i)))
                return false;
        }

        return true;
    }
}