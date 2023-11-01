package racingcar.model;

import racingcar.constant.GameSettingCharacter;

public class Car {
    private final Name name;
    private int record;

    public Car(String name, int record) {
        this.name = new Name(name);
        this.record = record;
    }

    public void addRecord() {
        record++;
    }

    public String getName() {
        return name.getName();
    }

    public String getNameAndRecord() {
        return getName() + GameSettingCharacter.COLON.get() +
                GameSettingCharacter.MOVED_LETTER.get().repeat(record) + "\n";
    }

    public int getRecord() { return record; }
}
