package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.constant.ErrorMessage;
import racingcar.constant.ServiceMessage;
import racingcar.input.NameCounter;
import racingcar.input.NameValidator;

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

        // 예외 처리
        if(!NameValidator.hasValidCharacters(inputNames)) {
            throw new IllegalArgumentException(getErrorMessage("name"));
        }

        if (NameCounter.getCount(inputNames) > 1) {
            Arrays.stream(inputNames.split(","))
                    .filter(name -> name.length() > 5)
                    .findFirst()
                    .ifPresent(name -> {
                        throw new IllegalArgumentException(getErrorMessage("name"));
                    });
        } else {
            if(inputNames.length() > 5) {
                throw new IllegalArgumentException(getErrorMessage("name"));
            }
        }
    }
}
