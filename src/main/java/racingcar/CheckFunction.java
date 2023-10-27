package racingcar;

import java.util.List;

public class CheckFunction {
    public CheckFunction() {}
    public boolean isValidInputList(List<String> inputData) {
        try {
            isStringLengthCheck(inputData);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
        return false;
    }

    public void isStringLengthCheck(List<String> inputData){
        for (String s : inputData) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("One of the strings exceeds the allowed length: " + s);
            }
        }
    }

    public int isValidInputNumber(String numberOfTimeToString) {
        try {
            int numberOfTime = Integer.parseInt(numberOfTimeToString);
            isIntegerCheck(numberOfTime);
            return numberOfTime;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    public void isIntegerCheck(int numberOfTime) {
        if (numberOfTime <= 0) {
            throw new IllegalArgumentException("The number must be greater than 0.");
        }
    }
}
