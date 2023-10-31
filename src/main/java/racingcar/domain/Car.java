package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Car extends IndexModel {

    private String name;
    private List<Integer> pickedNumbers = new ArrayList<>();
    private int lastPosition = 0;
    private List<Integer> positions = new ArrayList<>();

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public boolean isNameLengthOver(int length) {
        return name.length() > length;
    }

    public boolean matchNamePattern(String regEx) {
        return Pattern.matches(regEx, name);
    }

    public int calcPickedNumberSize() {
        return pickedNumbers.size();
    }

    public void insertPickedNumber(int num) {
        pickedNumbers.add(num);
    }

    public int getLastPosition() {
        return lastPosition;
    }

    public boolean isPositionSameOrOver(int maxPosition) {
        return lastPosition >= maxPosition;
    }

    public void moveForward() {
        lastPosition++;
    }
}
