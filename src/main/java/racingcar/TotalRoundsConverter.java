package racingcar;

public class TotalRoundsConverter {

    public int convert(String input) {
        checkIsDigit(input);
        return Integer.parseInt(input);
    }

    private void checkIsDigit(String input) {
        char[] characterizedInput = input.toCharArray();
        for (char number : characterizedInput) {
            if ('0' > number || '9' < number) {
                throw new IllegalArgumentException();
            }
        }
    }

}
