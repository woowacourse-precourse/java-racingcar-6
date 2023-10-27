package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Machines implements Showable, Gettable {
    private static final String inputMachineNameInstruction = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private String machineNames;

    @Override
    public void showMessage() {
        System.out.println(inputMachineNameInstruction);
    }

    @Override
    public String getInput() {
        return machineNames = readLine();
    }
}
