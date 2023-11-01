package racingcar;

public class TotalRoundsConverter {

    public int convert(String input) {
        checkIsDigit(input);
        int totalRounds = Integer.parseInt(input);
        checkUnder1(totalRounds);
        return totalRounds;
    }

    private void checkIsDigit(String input) {
        char[] characterizedInput = input.toCharArray();
        for (char number : characterizedInput) {
            if ('0' > number || '9' < number) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkUnder1(int i) {
        if (1 > i) {
            throw new IllegalArgumentException();
        }
    }

}
