package racingcar.model;

import racingcar.constant.GameSettingCharacter;

public class Car {
    private final Name name;
    private String record;

    public Car(String name) {
        this.name = new Name(name);
        this.record = "";
    }

    public void addRecord() {
        record += GameSettingCharacter.MOVED_LETTER.get();
    }

    public String getName() {
        return name.getName();
    }

    public String getNameAndRecord() {
        return getName() + GameSettingCharacter.COLON.get() + record + "\n";
    }

    public int getDistance() { return record.length(); }
}
