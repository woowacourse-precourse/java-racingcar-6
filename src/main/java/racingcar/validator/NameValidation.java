package racingcar.validator;

import java.util.Collections;
import java.util.List;
import racingcar.util.InputManufacture;

public class NameValidation {

    public void validate(String input) {
        checkWord(input);
        checkDuplicate(input);
        checkCount(input);
    }

    private void checkWord(String input) {
        if (!input.matches("^([a-zA-Z]{1,5})(,[a-zA-Z]{1,5})*$")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(String input) {
        InputManufacture inputManufacture = new InputManufacture();
        List<String> carCheckList = inputManufacture.makeNameList(input);
        for (String s : carCheckList) {
            if (Collections.frequency(carCheckList, s) > 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkCount(String input) {
        String[] carCheckList = input.split((","));
        if (carCheckList.length < 2) {
            throw new IllegalArgumentException();
        }
    }
}