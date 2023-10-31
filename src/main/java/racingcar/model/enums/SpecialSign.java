package racingcar.model.enums;

public enum SpecialSign {

    SEPARATOR(","),
    COLON(":"),
    HYPHEN("-"),
    NEW_LINE("\n"),
    SPACE(" ");

    private final String sign;

    SpecialSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    public static String drawHyphen(int distance) {
        return new StringBuilder()
                .append(HYPHEN.getSign().repeat(Math.max(0, distance)))
                .append(NEW_LINE.getSign())
                .toString();
    }
}
