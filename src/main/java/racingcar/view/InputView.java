package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class InputView {
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
}
