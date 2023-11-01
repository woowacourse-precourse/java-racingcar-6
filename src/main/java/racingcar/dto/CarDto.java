package racingcar.dto;

public class CarDto {

    private final String name;
    private final int position;
    private static final String DELIMITER_COLON = " : ";
    private static final String DELIMITER_BAR = "-";

    public CarDto(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return name + DELIMITER_COLON + DELIMITER_BAR.repeat(position);
    }
}
