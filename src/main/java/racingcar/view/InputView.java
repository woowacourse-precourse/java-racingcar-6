package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class InputView {

    static public String[] getCarName() {
        try {
            return readLine().split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid car name");
        }
    }

    static public int getTryNumber() {
        try {
            String input = readLine();
            if (!input.matches("\\d+")) {
                throw new IllegalArgumentException("Invalid try number");
            }
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid try number");
        }
    }
}
