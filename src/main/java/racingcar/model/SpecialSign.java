package racingcar.model;

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
        String drawDistance = "";
        for (int i = 0; i < distance; i++) {
            drawDistance += HYPHEN.getSign();
        }
        return drawDistance + NEW_LINE.getSign();
    }
}
