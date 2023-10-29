package racingcar.enums;

public enum Constants {
    NAME_LENGTH(5),
    BLANK_LENGTH(0)
    ;

    private int number;

    Constants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
