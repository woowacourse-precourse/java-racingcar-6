package racingcar;

public enum Number {
    MIN(0), TWO(2), MAX(9), RANDOM_VALUE(4), NAME_LENGTH(5);

    private int value;
    Number(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
