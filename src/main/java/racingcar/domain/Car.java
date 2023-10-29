package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Car {

    Long id;
    String name;
    int currentPosition = 0;
    List<Integer> pickedNumbers = new ArrayList<>();

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNameLengthOver(int length) {
        return name.length() > length;
    }

    public boolean matchNamePattern(String regEx) {
        return Pattern.matches(regEx, name);
    }
}
