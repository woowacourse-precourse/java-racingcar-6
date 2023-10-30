package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    public static void playGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNamesInput = readLine();

        String[] carNamesArray = carNamesInput.split(",");

        List<String> carNamesList = new ArrayList<>();

        for (String s : carNamesArray) {
            if (s.length() >= 5) {
                throw new IllegalArgumentException();
            }

            carNamesList.add(s);
        }

        for (String s: carNamesList) {
            System.out.println(s);
        }
    }
}
