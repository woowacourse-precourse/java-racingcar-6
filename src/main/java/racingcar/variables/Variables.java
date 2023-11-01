package racingcar.variables;

public enum Variables {
    RAND_NUM_EXPECT("Is Generated number bigger than", 4);

    private Variables(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private int value;
    public int getValue() {
        return value;
    }
}
