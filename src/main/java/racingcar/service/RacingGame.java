package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.LinkedHashMap;
import racingcar.constant.ErrorMessage;
import racingcar.constant.ServiceMessage;
import racingcar.input.count.CountValidator;
import racingcar.input.name.NameCounter;
import racingcar.input.name.NameValidator;

public class RacingGame {
    private String getErrorMessage(String errorType) {
        if(errorType.equals("name")) {
            return ErrorMessage.NAME_ERROR.errorMessage;
        }
        return ErrorMessage.COUNT_ERROR.errorMessage;
    }
    public void startGame() {
        System.out.print(ServiceMessage.START.serviceMessage);

        // 이름 입력 받기
        String inputNames = Console.readLine();

        // 이름과 자동차 전진 횟수를 기록하는 LinkedHashMap
        LinkedHashMap<String, Integer> nameToDistance = new LinkedHashMap<>();


        // 예외 처리
        for(String name : inputNames.split(",")) {
            if(!NameValidator.hasValidCharacters(name)) {
                throw new IllegalArgumentException(getErrorMessage("name"));
            }

            if(name.length() > 5) {
                throw new IllegalArgumentException(getErrorMessage("name"));
            }

            nameToDistance.put(name, 0);
        }

        // 횟수 입력 문구 출력
        System.out.print(ServiceMessage.INPUT.serviceMessage);

        // 횟수 입력 받기
        String inputCount = Console.readLine();
        if(!CountValidator.isValid(inputCount)) {
            throw new IllegalArgumentException(getErrorMessage("count"));
        }

        int n = Integer.parseInt(inputCount);

        System.out.println(nameToDistance);
    }
}
