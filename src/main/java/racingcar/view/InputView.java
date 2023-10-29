package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.TrialNumber;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public TrialNumber getTrialNumber() {
        OutputView.printTrialNumberInputText();
        String trialNumberInput = Console.readLine().trim();
        return new TrialNumber(trialNumberInput);
    }

    public Cars getCarsFromUser() {
        OutputView.printCarNameInputText();
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
