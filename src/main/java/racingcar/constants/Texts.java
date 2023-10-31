package racingcar.constants;

public enum Texts {
    STARTINPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"), TRYCOUNTINPUT("시도할 회수는 몇회인가요?"),
    EXCUTERESULT("실행 결과"), FINALWINNER("최종 우승자 : "), SPACE(" "), COMMAS(","),
    BAR("-"), COLON(":");
    private String value;

    @Override
    public String toString() {
        return value;
    }

    Texts(String value) {
        this.value = value;
    }
}
