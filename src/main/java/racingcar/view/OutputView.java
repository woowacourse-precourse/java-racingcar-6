package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RACING_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String SINGLE_DASH = "-";
    private static final String COLON = " : ";
    private static final String DELIMITER_COMMA_AND_ONE_BLANK = ", ";

    public void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarDistanceNow(Racing racing){
        List<Car> cars = racing.getCars();
        for(Car car : cars){
            String name = car.getName();
            Integer distance = car.getDistance();
            String distatnceString = SINGLE_DASH.repeat(distance);
            System.out.println(name + COLON + distatnceString);
        }
        System.out.println();
    }
    public void printRacingWinner(List<String> winners){
        String result = winners.stream().collect(Collectors.joining(DELIMITER_COMMA_AND_ONE_BLANK));
        System.out.println(RACING_WINNER_MESSAGE + result);
    }
}
