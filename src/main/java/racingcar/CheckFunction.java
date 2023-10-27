package racingcar;

public class CheckFunction {
    public CheckFunction() {}
    public boolean isValidInput(String[] inputData) {
        try {
            isStringLengthCheck(inputData);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
        return false;
    }

    public void isStringLengthCheck(String[] inputData){
        for (String s : inputData) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("One of the strings exceeds the allowed length: " + s);
            }
        }
    }

}
