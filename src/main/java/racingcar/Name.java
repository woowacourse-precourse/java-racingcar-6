package racingcar;

import static racingcar.ExceptionMessage.BLANK_CAR_NAME;
import static racingcar.ExceptionMessage.OUT_OF_CAR_NAME_LENGTH;
public class Name {
    private final String name;
    private static final int MAX_NAME_LENGTH = 6;
    public Name(String name) {
        this.name = validate(name);
    }

    private String validate(String name){
        validateCarNameLength(name);
        validateBlankCarName(name);

        return name;

    }
    private void validateCarNameLength(String name) {
        if (name.length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_CAR_NAME_LENGTH.getMessage());
        }
    }
    private void validateBlankCarName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.getMessage());
        }
    }

    public String getName(){
        return this.name;
    }
}
