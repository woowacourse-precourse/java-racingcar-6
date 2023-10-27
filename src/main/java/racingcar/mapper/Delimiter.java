package racingcar.mapper;

public enum Delimiter {

    NAME("쉼표", ",");

    private final String name;
    private final String shape;

    Delimiter(String name, String shape) {
        this.name = name;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public String getShape() {
        return shape;
    }
}
