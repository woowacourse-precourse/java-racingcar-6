package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputFunction {
    public InputFunction() {}
    public InputResult InputData() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String InputData = readLine();
        CheckFunction checkFunction = new CheckFunction();
        List<String> InputDataList = new java.util.ArrayList<>(List.of(InputData.split(",")));

        if(checkFunction.isValidInputList(InputDataList))
            InputDataList.set(0, "Error");

        System.out.println("시도할 회수는 몇회인가요?");
        String NumberOfTimeToString = readLine();
        int NumberOfTime = checkFunction.isValidInputNumber(NumberOfTimeToString);
        return new InputResult(InputDataList, NumberOfTime);
    }

    static class InputResult {
        List<String> inputDataList;
        int numberOfTime;

        InputResult(List<String> inputDataList, int numberOfTime) {
            this.inputDataList = inputDataList;
            this.numberOfTime = numberOfTime;
        }
    }
}
