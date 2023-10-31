package racingcar.constant;

public enum GameSettingCharacter {
    SEPARATOR_NAME("쉼표"),
    SEPARATOR_CHARACTER(","),
    MOVED_LETTER("-"),
    COLON(" : ");

    private final String settingCharacter;

    GameSettingCharacter(String settingCharacter) {
        this.settingCharacter = settingCharacter;
    }

    public String get() {
        return settingCharacter;
    }
}
