package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputValidation;

import java.util.ArrayList;

public class RacePreparation {
    InputValidation inputValidation = new InputValidation();

    public RacePreparation() {
    }

    // 1. 사용자로부터 자동차의 이름을 입력 받는다
    public ArrayList<String> askCarNames() {
        String InputCars = Console.readLine();
        // 1-1. 자동차 이름은 쉼표를 기준으로 구분한다.
        String[] splitCarNames = inputValidation.splitNamesByComma(InputCars);


        // splitCarNames변수를 String][] -> ArrayList<Integer>
        ArrayList<String> saveCarNames = new ArrayList<>();
        for (int i = 0; i < splitCarNames.length; i++) {
            saveCarNames.add(splitCarNames[i]);
        }
        return saveCarNames;
    }

    // 2. 사용자로 부터 경주차가 이동을 시도할 횟수를 입력 받기
    public int askExecuteCount() throws IllegalArgumentException {
        String inputCount = Console.readLine();

        // 입력값이 숫자형인지 확인
        if (!inputValidation.isInt(inputCount)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputCount);
    }

}
