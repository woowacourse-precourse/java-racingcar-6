package racingcar.model;

public class Car {
    private static final String MOVED_LETTER = "-";
    private Name name;
    private String record;

    public Car(String name) {
        this.name = new Name(name);
        this.record = "";
    }

    public void addRecord() {
        record += MOVED_LETTER;
    }
}
