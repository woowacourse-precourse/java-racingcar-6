package racingcar;

public class Machines implements Showable {
    private static final String inputMachineNameInstruction = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    @Override
    public void showMessage() {
        System.out.print(inputMachineNameInstruction);
    }
}
