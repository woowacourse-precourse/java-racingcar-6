package racingcar.model;

import java.util.Objects;

public class CarName {
    String name;
    static final int MAX_NAME_LENGTH = 5;

    public CarName(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarName carName)) {
            return false;
        }
        return name.equals(carName.name);
    }
}
