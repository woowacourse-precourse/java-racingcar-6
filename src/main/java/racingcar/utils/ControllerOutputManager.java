package racingcar.utils;

public class ControllerOutputManager {
    private static final String START_PRINT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INSTRUCTION = "시도할 회수는 몇회인가요?";

    public void startPrint() {
        System.out.println(START_PRINT);
    }

    public void Instruction() {
        System.out.println(INSTRUCTION);
    }
}
