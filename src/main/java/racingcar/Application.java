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
    }

    public static List<String> listConversion(String racingCar) throws IllegalArgumentException {
        List<String> racer = new ArrayList<String>();
        String[] splitStr = racingCar.split(",");

        for (int i = 0; i < splitStr.length; i++) {
            racer.add(splitStr[i]);
        }

        if (!isValidName(racer))
            throw new IllegalArgumentException("올바른 자동차 이름이 아닙니다.");

        return racer;
    }

    private static boolean isValidName(List<String> racer) throws IllegalArgumentException {
        for (int i = 0; i < racer.size(); i++) {
            if (racer.get(i).length() > 5)
                return false;
        }

        return true;
    }
}