package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class InputView {

    static public String[] getCarName() {
        try {
            return readLine().split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static public int getTryNumber() {

        try {
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
