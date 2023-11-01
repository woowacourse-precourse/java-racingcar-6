package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessage;
import racingcar.constant.ServiceMessage;
import racingcar.input.count.CountValidator;
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
           NameValidator.isValid(name);
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
                System.out.println(key + " : " + "-".repeat(countsByName[t]));
            }
            System.out.println();
        }

        // 최대 전진 횟수 찾기
        int maxCount = Arrays.stream(countsByName).max().orElse(-1);

        // 최대 전진 횟수와 일치하는 모든 운전자의 이름 찾기
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if (countsByName[i] == maxCount) {
                winners.add(names[i]);
            }
        }

        System.out.println(ServiceMessage.WINNER.serviceMessage+ winners.toString().replaceAll("[\\]\\[]",""));
    }
}
