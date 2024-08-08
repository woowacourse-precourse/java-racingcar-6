package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.TrialNumber;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String TRIAL_NUMBER_INPUT_TEXT = "시도할 회수는 몇회인가요?\n";
    private static final String CAR_NAME_INPUT_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

    public TrialNumber getTrialNumber() {
        System.out.print(TRIAL_NUMBER_INPUT_TEXT);
        String trialNumberInput = Console.readLine().trim();
        return new TrialNumber(trialNumberInput);
    }

    public Cars getCarsFromUser() {
        System.out.print(CAR_NAME_INPUT_TEXT);
        List<String> carNames = splitInputByComma(Console.readLine());
        return new Cars(carNames);
    }

    public List<String> splitInputByComma(String input) {
        String[] splitInputArray = input.split(",");
        return trimInputOneByOne(splitInputArray);
    }

    private List<String> trimInputOneByOne(String[] inputList) {
        List<String> trimInputList = new ArrayList<>();
        for (String input : inputList) {
            trimInputList.add(input.trim());
        }
        return trimInputList;
    }

    public void closeConsole() {
        Console.close();
    }
}
