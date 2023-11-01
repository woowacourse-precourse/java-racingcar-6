package racingcar.enums;

public enum Instructions {

    CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과");

    private final String instruction;

    private Instructions(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }
}
