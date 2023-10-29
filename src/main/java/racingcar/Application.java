package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        racingGame();

    }

    private static void racingGame () {
        String carNames = inputCarNames();
        int trialTimes = inputTrialTimes();
        List<String> carNameList = parseCarNamesToList(carNames);
        
        

    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }

    private static int inputTrialTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static List<String> parseCarNamesToList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .collect(Collectors.toList());
    }

}
