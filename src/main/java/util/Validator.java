package util;

import java.util.List;

public class Validator {
    private static final int MIN = 1;
    private static final int MAX = 5;

    public void checkCarNamesInput(String input, List<String> carList) throws IllegalArgumentException{
        checkAllOfInput(input);
        checkAllOfEachInput(carList);
    }

    private void checkAllOfEachInput(List<String> carList) {
        checkDuplicate(carList);
        checkEachSpaceAndLength(carList);
    }

    private void checkAllOfInput(String input) {
        checkEmpty(input);
        checkLastIndex(input);
    }

    private void checkEachSpaceAndLength(List<String> carList) {
        for (String carName : carList) {
            checkEachLength(carName);
            checkEachSpace(carName);
        }
    }

    private void checkEachSpace(String carName) {
        if(carName.contains(" ")) {
            throwSpaceException();
        }
    }

    private void throwSpaceException() {
        throw new IllegalArgumentException();
    }

    private void checkEachLength(String carName) {
        if (MAX < carName.length()) {
            throw new IllegalArgumentException();
        }
        if (MIN > carName.length()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<String> carList) {
        for (int i = 0; i < carList.size(); i++)
            compareDuplicate(i, carList);
    }

    private void compareDuplicate(int i, List<String> carList) {
        for (int j = i + 1; j < carList.size(); j++)
            checkEqual(carList.get(i), carList.get(j));
    }

    private void checkEqual(String carName1, String carName2) {
        if(carName1.equals(carName2)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLastIndex(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throwMinLengthException();
        }
    }

    private void throwMinLengthException() {
        throw new IllegalArgumentException();
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkTrialNumberInput(String input) throws IllegalArgumentException{
        checkEmpty(input);
        checkChar(input);
    }

    private void checkChar(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
