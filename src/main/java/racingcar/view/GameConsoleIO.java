package racingcar.view;


import java.util.List;

public class GameConsoleIO {

    private final static String PRINT_FORMAT_CAR_LOCATION_BY_NAME = "%s : ";
    private final static String PRINT_FORMAT_WINNERS = "최종 우승자 : %s";

    private final static String CAR_LOCATION_INDICATOR = "-";
    private final static String MEMBER_SEPARATOR = ",";


    private final static String SHOW_RESULT_MESSAGE = "실행 결과";


    public GameConsoleIO() {
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
