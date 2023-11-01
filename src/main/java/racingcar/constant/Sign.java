package racingcar.constant;

public enum Sign {
    COLONE(" : "),
    TRACE("-");


    private String sign;


    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
