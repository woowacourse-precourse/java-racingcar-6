package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingCars;

import java.util.List;

public class OutputValue {

    private static final String RACING_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String RACING_RANGE_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과";

    private static final String GAME_RESULT_MESSAGE = "최종 우승자 : ";


    public static void getNamesMessage(){ System.out.println(RACING_CARS_NAME_MESSAGE); }

    public static void getRangeMessage(){ System.out.println(RACING_RANGE_MESSAGE); }

    public static void executionResultMessage(){ System.out.println(EXECUTION_RESULT_MESSAGE); }

    public static void gameProgressMessage(RacingCars racingCars) {
        for(Car car : racingCars.getCars()) { System.out.println(createGameProgressMessage(car)); }
        System.out.println();
    }

    public static void gameResultMessage(RacingCars racingCars) {

        if(racingCars.getWinners().size() == 1) {
            System.out.println(singleWinnerMessage(racingCars.getWinners().get(0)));
            return;
        }

        System.out.println(multipleWinnerMessage(racingCars.getWinners()));
    }


    private static String createGameProgressMessage(Car car) {

        StringBuilder messageForm = new StringBuilder();

        messageForm.append(car.getName());
        messageForm.append(" : ");
        messageForm.append("-".repeat(car.getLocation()));

        return messageForm.toString();
    }

    private static String singleWinnerMessage(String name) {

        StringBuilder messageForm = new StringBuilder();

        messageForm.append(GAME_RESULT_MESSAGE);
        messageForm.append(name);

        return messageForm.toString();
    }

    private static String multipleWinnerMessage(List<String> winners) {

        StringBuilder messageForm = new StringBuilder();

        messageForm.append(GAME_RESULT_MESSAGE);
        messageForm.append(String.join(", ", winners));

        return messageForm.toString();
    }
}
