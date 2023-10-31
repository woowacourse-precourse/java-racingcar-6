package racingcar.model;

import java.util.List;

public class Car {
    private static final String MOVED_LETTER = "-";
    private static final String COLON = " : ";
    private Name name;
    private String record;

    public Car(String name) {
        this.name = new Name(name);
        this.record = "";
    }

    public void addRecord() {
        record += MOVED_LETTER;
    }

    public String getName() {
        return name.getName();
    }

    public String getNameAndRecord() {
        return getName() + COLON + record + "\n";
    }

    public int getDistance() { return record.length(); }
}
