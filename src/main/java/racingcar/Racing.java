package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {
    private Script script;
    private List<String> names;
    private List<StringBuilder> move;

    public Racing() {
        script = new Script();
        move = new ArrayList<>();
    }

    private void inputCarName() {
        script.start();
        names = Arrays.asList(readLine().split(","));
    }

    private boolean isNumber(String number) {
        for (int index = 0; index < number.length(); index++) {
            if (number.charAt(index) < '0' && number.charAt(index) > '9') {
                return false;
            }
        }

        return true;
    }

    private int inputTryNumber() {
        script.askTry();

        String input = readLine();
        int tryNumber;

        if (!isNumber(input)){
            throw new IllegalArgumentException();
        }

        tryNumber = Integer.parseInt(input);

        return tryNumber;
    }

    public void start() {
        int tryNumber;

        inputCarName();
        tryNumber = inputTryNumber();
    }

}
