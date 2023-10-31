package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Cars implements Showable, Gettable {
    private static final int INPUT_LETTER_LIMIT = 5;
    private static final String INPUT_CAR_NAME_INSTRUCTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ILLEGALARGUMENTEXCEPTION_INSTRUCTION = "Please name cars within 5 letters.";
    private List<String> carNameList = new ArrayList<>();

    @Override
    public void showMessage() {
        System.out.println(INPUT_CAR_NAME_INSTRUCTION);
    }

    @Override
    public String getInput() throws IllegalArgumentException {
        String carNames = readLine();
        carNameList = Arrays.asList(carNames.split(","));

        validateInput(carNameList);

        return carNames;
    }

    private void validateInput(List<String> carNameList) {
        Predicate<String> isWithinFiveLetters = str -> str.length() <= INPUT_LETTER_LIMIT;

        if (carNameList.stream().anyMatch(carName -> !isWithinFiveLetters.test(carName))) {
            throw new IllegalArgumentException(ILLEGALARGUMENTEXCEPTION_INSTRUCTION);
        }
    }

    public List<String> getCarNameList() {
        return carNameList;
    }
}
