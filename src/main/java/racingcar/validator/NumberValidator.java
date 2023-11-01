package racingcar.validator;

public class NumberValidator {

    private final int number;

    public int getNumber() {
        return number;
    }

    public NumberValidator(
            final String inputNumber
    ) {
        validateNumber(inputNumber);
        this.number = Integer.parseInt(inputNumber);
    }


    public void validateNumber(
            final String number
    ) {
        String regex = "[1-9]+";

        if(number.matches(regex)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
