package racingcar.view;

import java.util.List;
import racingcar.model.CarDto;

public class OutputView {
    private final static String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String REQUEST_NUMBER_OF_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String RACE_RESULT_MESSAGE = "실행 결과";
    private final static String MOVEMENT = "-";
    private final static String WINNER_IS = "최종 우승자 : ";

    public void requestCarNamesMessage() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
    }

    public void requestNumberOfTryMessage() {
        System.out.println(REQUEST_NUMBER_OF_TRY_MESSAGE);
    }

    public void raceResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public void raceResultByOrderMessage(List<CarDto> cars) {
        for(CarDto car : cars) {
            System.out.println(car.getName() + " : " + MOVEMENT.repeat(car.getPosition()));
        }
    }

    public void raceWinnerMessage(List<String> cars) {
        System.out.println(WINNER_IS + String.join(", ", cars));
    }
}
