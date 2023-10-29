package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Machines implements Showable, Gettable {
    private static final int INPUT_LETTER_LIMIT = 5;
    private static final String INPUT_MACHINE_NAME_INSTRUCTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ILLEGALARGUMENTEXCEPTION_INSTRUCTION = "Please name machines within 5 letters.";
    private static List<String> machineNameList = new ArrayList<>();

    @Override
    public void showMessage() {
        System.out.println(INPUT_MACHINE_NAME_INSTRUCTION);
    }

    @Override
    public String getInput() {
        String machineNames = readLine();

        machineNameList = Arrays.asList(machineNames.split(","));

        Predicate<String> isWithinFiveLetters = str -> str.length() <= INPUT_LETTER_LIMIT;

        if (machineNameList.stream().anyMatch(machineName -> !isWithinFiveLetters.test(machineName))) {
            throw new IllegalArgumentException(ILLEGALARGUMENTEXCEPTION_INSTRUCTION);
        }

        return machineNames;
    }

    public List<String> getMachineNameList() {
        return machineNameList;
    }
}
