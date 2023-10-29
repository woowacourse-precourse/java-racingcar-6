package racingcar.viewer;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.Car;

public class Output_Viewer {
    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String WINNERS_POSTFIX = "최종 우승자 : ";
    private static final String NAME_SEPARATOR = ", ";
    private static final String POSITION_INDICATOR = "-";

    public static void Result_Message() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public static void Status(List<Car> cars) {
        for (Car car : cars) {
            int car_position = car.Get_Position();
            String progress_bar = POSITION_INDICATOR.repeat(car_position);
            System.out.println(car.Get_Name() + " : " + progress_bar);
        }
        System.out.println();
    }

    public static void Winners(List<Car> winners) {
        String winner_list = winners.stream()
                .map(Car::Get_Name)
                .collect(Collectors.joining(NAME_SEPARATOR));
        System.out.println(WINNERS_POSTFIX + winner_list);
    }
}
