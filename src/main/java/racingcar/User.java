package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private static final String OPERATOR = ",";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";



    public int setTrialNumber() {
        System.out.println(TRIAL_MESSAGE);
        String inputCountsByClient = Console.readLine();
        int attemptCounts;
        try {
            Validation.checkException(inputCountsByClient);
            attemptCounts = Integer.parseInt(inputCountsByClient);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            attemptCounts = setTrialNumber();
        }
        return attemptCounts;
    }

    public List<String> setCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        List<String> carNameList = Arrays.stream(carNames.split(OPERATOR))
                .collect(Collectors.toList());
        try {
            Validation.checkException(carNameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            carNameList = setCarName();
        }
        return carNameList;
    }
}
