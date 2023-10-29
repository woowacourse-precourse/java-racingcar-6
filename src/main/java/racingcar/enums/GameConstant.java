package racingcar.enums;

public enum GameConstant {
    TRUE("true"),
    FALSE("false"),
    MAXIMUM_LENGTH_OF_CAR_NAME("5"),
    NUMBERS("0123456789");

    private final String content;

    GameConstant(String content) {
        this.content = content;
    }

    public Boolean getContentToBoolean() {
        if (this.content.equals("true")) {
            return true;
        } else if (this.content.equals("false")) {
            return false;
        }

        throw new IllegalCallerException("함수가 올바르지 않은 형식으로 사용되었습니다.");
    }

    public Integer getContentToInteger() {
        String numbers = GameConstant.NUMBERS.getContent();

        if (numbers.contains(this.content)) {
            return Integer.parseInt(this.content);
        }

        throw new IllegalCallerException("함수가 올바르지 않은 형식으로 사용되었습니다.");
    }

    public String getContent() {
        return this.content;
    }
}
