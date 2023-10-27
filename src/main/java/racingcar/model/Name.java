package racingcar.model;

import java.util.Objects;
import racingcar.validator.BasicValidator;
import racingcar.validator.NameValidator;

public class Name {

    private final String name;
    private static final BasicValidator<String> carNameValidator = new NameValidator();

    public Name(String name) {
        carNameValidator.validate(name);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
