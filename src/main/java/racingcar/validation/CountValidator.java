package racingcar.validation;

public class CountValidator {

    public void isContainLetter(String count) {
        if (!count.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_LETTER.getMessage());
        }
    }

    public void isNotNaturalNum(String count) {
        double num = Double.parseDouble(count);
        if (num != (int) num) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUM.getMessage());
        }
        if (num <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUM.getMessage());
        }
    }
}
