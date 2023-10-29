package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Scanner;

public class InputView {

    public static String[] readCarNames(Scanner scanner) {
        String names = readLine();
        String[] carNames = new String[]{};
        try {
            carNames = names.split(",");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return carNames;
    }
}
