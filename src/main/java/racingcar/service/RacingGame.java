package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessage;
import racingcar.constant.ServiceMessage;
import racingcar.input.count.CountValidator;
import racingcar.input.name.NameReader;
import racingcar.input.name.NameValidator;
import racingcar.output.ServicePrinter;

public class RacingGame {
    public void startGame() {
        ServicePrinter servicePrinter = new ServicePrinter();
        servicePrinter.printStartMessage();

        // 이름 입력 받기
        String inputNames = Console.readLine();

        // 예외 처리
        String[] names = NameReader.read();
        int[] countsByName = new int[names.length];

        // 횟수 입력 문구 출력
        servicePrinter.printInputMessage();

        // 횟수 입력 받기
        String inputCount = Console.readLine();
        if(!CountValidator.isValid(inputCount)) {
            throw new IllegalArgumentException(ErrorMessage.getErrorMessage("count"));
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

        servicePrinter.printWinnerMessage(winners);
    }
}
