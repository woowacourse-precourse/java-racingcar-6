package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputFunction {
    public InputFunction() {}
    public String[] InputData() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String InputData = readLine();
        String[] InputDataList = InputData.split(",");
        CheckFunction checkFunction = new CheckFunction;
        if(checkFunction.isValidInput(InputDataList, InputDataList.length))
            return InputDataList;
    }
}
