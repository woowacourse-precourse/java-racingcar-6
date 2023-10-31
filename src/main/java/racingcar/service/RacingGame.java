package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
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

        // 예외 처리
        String[] names = inputNames.split(",");
        int[] countsByName = new int[names.length];
        for(String name : names) {
            if(!NameValidator.hasValidCharacters(name)) {
                throw new IllegalArgumentException(getErrorMessage("name"));
            }

            if(name.length() > 5) {
                throw new IllegalArgumentException(getErrorMessage("name"));
            }
        }

        // 횟수 입력 문구 출력
        System.out.print(ServiceMessage.INPUT.serviceMessage);

        // 횟수 입력 받기
        String inputCount = Console.readLine();
        if(!CountValidator.isValid(inputCount)) {
            throw new IllegalArgumentException(getErrorMessage("count"));
        }

        int n = Integer.parseInt(inputCount);

        System.out.print(ServiceMessage.OUTPUT.serviceMessage);
        int totalName = names.length;
        while(n-- > 0) {
            for(int t = 0; t < totalName; t++) {
                String key = names[t];
                if(RacingCarController.isMoveForward()) {
                    countsByName[t]++;
                }
            }
        }
    }
}
