package racingcar.util;

public enum GameSettingNumber {
    MAX_LENGTH(5),
    RANGE_START_NUMBER(0),
    RANGE_END_NUMBER(9),
    MOVE_CRITERIA(4);

    private final int settingNumber;

    GameSettingNumber(int settingNumber) {
        this.settingNumber = settingNumber;
    }

    public int get() {
        return settingNumber;
    }

}
