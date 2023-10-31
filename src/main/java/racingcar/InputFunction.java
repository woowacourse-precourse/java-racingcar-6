package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputFunction {
    public InputFunction() {
    }

    public InputResultModel InputData() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String InputData = readLine();
        CheckFunction checkFunction = new CheckFunction();
        List<String> InputDataList = new java.util.ArrayList<>(List.of(InputData.split(",")));
        int NumberOfTime;
        if (checkFunction.isValidInputList(InputDataList)) {
            NumberOfTime = -1;
            return new InputResultModel(InputDataList, NumberOfTime);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        String NumberOfTimeToString = readLine();
        NumberOfTime = checkFunction.isValidInputNumber(NumberOfTimeToString);
        return new InputResultModel(InputDataList, NumberOfTime);
    }
}