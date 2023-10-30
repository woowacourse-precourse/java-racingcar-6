package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class CarViewer {

    private static CarViewer carViewer;

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.";
    private static final String INPUT_NAME_DELIMITER = ",";
    private static final String GUIDE_NAME_DIVIED;
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    private static final String EXECUTE = "실행 결과";

    static {
        GUIDE_NAME_DIVIED = "(이름은 쉼표(" + INPUT_NAME_DELIMITER + ") 기준으로 구분)";
    }


    private CarViewer() {
    }

    public static CarViewer getInstance() {
        if (carViewer == null) {
            carViewer = new CarViewer();
        }

        return carViewer;
    }

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES + GUIDE_NAME_DIVIED);
        String inputCarNames = Console.readLine();
        return List.of(inputCarNames.split(","));
    }

    public int inputAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        String inputAttemptCount = Console.readLine();
        try {
            return Integer.parseInt(inputAttemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자이어야 합니다.", e);
        }

    }

    public void outputExecute() {
        System.out.println(EXECUTE);
    }

    public void outputWinner(List<String> winningCarNames) {
        String result = String.join(", ", winningCarNames);
        System.out.println("최종 우승자 : " + result);
    }

    public void outputStatus(Map<String, Integer> status) {
        for (String carName : status.keySet()) {
            System.out.println(carName + " : " + "-".repeat(status.get(carName)));
        }
    }
}
