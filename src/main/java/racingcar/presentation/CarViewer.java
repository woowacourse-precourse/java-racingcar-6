package racingcar.presentation;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarGameRound;
import racingcar.domain.CarName;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CarViewer {

    private static CarViewer carViewer;

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.";
    private static final String INPUT_NAME_DELIMITER = ",";
    private static final String GUIDE_NAME_DIVIED;
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    private static final String EXECUTE = "실행 결과";
    private static final String RESULT_DELIMITER = ", ";
    private static final String POSITION_SYMBOL = "-";
    private static final String WINNER = "최종 우승자";
    private static final String KEY_DELIMITER = " : ";

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

    public List<CarName> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES + GUIDE_NAME_DIVIED);
        String inputCarNames = Console.readLine();
        return Stream.of(inputCarNames.split(INPUT_NAME_DELIMITER))
                .map(CarName::new)
                .toList();
    }

    public CarGameRound inputGameRound() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        String inputAttemptCount = Console.readLine();

        return CarGameRound.createByString(inputAttemptCount);
    }

    public void outputExecute() {
        System.out.println(EXECUTE);
    }

    public void outputWinner(CarDTO.WinnerNames winningCarNames) {
        String result = String.join(RESULT_DELIMITER, winningCarNames.getNames());
        System.out.println(WINNER + KEY_DELIMITER + result);
        System.out.println();
    }

    public void outputResult(CarDTO.ProgressResult gameResult) {

        List<Map<String, Integer>> result = gameResult.getResult();
        for (Map<String, Integer> round : result) {
            for (String carName : round.keySet()) {
                System.out.println(carName + KEY_DELIMITER + POSITION_SYMBOL.repeat(round.get(carName)));
            }
            System.out.println();
        }
    }
}
