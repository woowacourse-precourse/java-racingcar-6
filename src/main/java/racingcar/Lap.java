package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.function.Predicate;

public class Lap implements Showable, Gettable {
    private static final String LAP_INSTRUCTION = "시도할 회수는 몇회인가요?";

    private String lap;

    @Override
    public void showMessage() {
        System.out.println(LAP_INSTRUCTION);
    }

    @Override
    public String getInput() {
        lap = readLine();

        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        if (!isNumeric.test(lap)) {
            throw new IllegalArgumentException();
        }

        return lap;
    }

    public String getLap() {
        return lap;
    }
}
