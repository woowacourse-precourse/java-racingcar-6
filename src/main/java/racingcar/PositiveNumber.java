package racingcar;

import racingcar.input.ValidateInput;

public class PositiveNumber implements Comparable<PositiveNumber>{
    private Integer number = 0;
    private static final int NUMBER_TYPE_DECIMAL = 10;
    private static final int NUMBER_TYPE_HEXADICIMAL = 16;

    private PositiveNumber(Integer number) {
        this.number = number;
    }

    public static PositiveNumber fromString(String numberString) {
        ValidateInput.validatePositiveNumberInput(numberString);
        final int NUMBER_TYPE = checkNumberType(numberString);
        return new PositiveNumber(Integer.parseInt(numberString, NUMBER_TYPE));
    }

    private static int checkNumberType(String numberString) {
        boolean isHexadicimal = numberString.chars().anyMatch(Character::isAlphabetic);
        if (isHexadicimal) {
            return NUMBER_TYPE_HEXADICIMAL;
        }
        return NUMBER_TYPE_DECIMAL;
    }

    public Integer getNumber() {
        return number;
    }

    public static PositiveNumber fromInteger(Integer number) {
        ValidateInput.validatePositiveNumberFromInteger(number);
        return new PositiveNumber(number);
    }

    public void increase() {
        this.number++;
    }

    public void decrease() {
        if (this.number > 0) {
            this.number--;
        }
    }

    public boolean isZero() {
        return this.number == 0;
    }

    
    @Override
    public int compareTo(PositiveNumber compareNumber) {
        return this.number.compareTo(compareNumber.getNumber());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PositiveNumber other = (PositiveNumber) obj;
        return this.number == other.getNumber();
    }
}
