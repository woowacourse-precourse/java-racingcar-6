package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.TrialNumber;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private InputView() {
    }

    public static TrialNumber getTrialNumber() {
        OutputView.printTrialNumberInputText();
        String trialNumberInput = Console.readLine().trim();
        return new TrialNumber(trialNumberInput);
    }

    public static Cars getCarsFromUser() {
        OutputView.printCarNameInputText();
        List<String> carNames = splitInputByComma(Console.readLine());
        return new Cars(carNames);
    }

    public static List<String> splitInputByComma(String input) {
        String[] splitInputArray = input.split(",");
        return trimInputOneByOne(splitInputArray);
    }

    private static List<String> trimInputOneByOne(String[] inputList) {
        List<String> trimInputList = new ArrayList<>();
        for (String input : inputList) {
            trimInputList.add(input.trim());
        }
        return trimInputList;
    }

    public static void closeConsole() {
        Console.close();
    }
}
