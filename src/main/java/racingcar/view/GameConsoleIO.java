package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.GameCondition;
import racingcar.validation.InputValidation;

public class GameConsoleIO {
    private final static String PRINT_FORMAT_CAR_LOCATION_BY_NAME = "%s : ";
    private final static String PRINT_FORMAT_WINNERS = "최종 우승자 : %s";

    private final static String CAR_LOCATION_INDICATOR = "-";
    private final static String MEMBER_SEPARATOR = ",";


    private final static String ASK_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ASK_MOVING_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String SHOW_RESULT_MESSAGE = "실행 결과";


    private final InputValidation inputValidation;

    public GameConsoleIO() {
        inputValidation = new InputValidation();
    }

    public List<String> getCarNames() {
        System.out.println(ASK_CAR_NAMES_MESSAGE);
        String carNames = Console.readLine().replaceAll("\\s", "");

        return Arrays.stream(carNames.split(MEMBER_SEPARATOR))
                .peek(name -> inputValidation.validateCarNameSize(name, GameCondition.NAME_SIZE.getValue()))
                .toList();
    }

    public int getMovingCount() {
        System.out.println(ASK_MOVING_COUNT_MESSAGE);
        String movingCount = Console.readLine().trim();

        inputValidation.validateMovingCount(movingCount);

        return Integer.parseInt(movingCount);
    }


    public void printExecuteResultMessage() {
        System.out.println();
        System.out.println(SHOW_RESULT_MESSAGE);
    }

    public void printCarLocationByCarName(String carName, int carLocation) {
        System.out.println(String.format(PRINT_FORMAT_CAR_LOCATION_BY_NAME, carName)
                + CAR_LOCATION_INDICATOR.repeat(carLocation));
    }

    public void printWinners(List<String> winners) {
        System.out.printf(String.format(PRINT_FORMAT_WINNERS, String.join(MEMBER_SEPARATOR + "\s", winners)));
    }

}
