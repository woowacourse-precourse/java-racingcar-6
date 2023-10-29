package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.function.Predicate;

public class RaceLap implements Showable, Gettable {
    private static final String RACE_LAP_INSTRUCTION = "시도할 회수는 몇회인가요?";
    private static final String ILLEGALARGUMENTEXCEPTION_INSTRUCTION = "Please type numbers.";
    private String raceLapNumber;

    @Override
    public void showMessage() {
        System.out.println(RACE_LAP_INSTRUCTION);
    }

    @Override
    public String getInput() {
        raceLapNumber = readLine();

        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        if (!isNumeric.test(raceLapNumber)) {
            throw new IllegalArgumentException(ILLEGALARGUMENTEXCEPTION_INSTRUCTION);
        }

        return raceLapNumber;
    }

    public String getRaceLapNumber() {
        return raceLapNumber;
    }
}
