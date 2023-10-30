package racingcar.view;

import java.util.List;
import racingcar.domain.CarList.CarDto;

public class OutputView {

    private final static String RACING_RESULT = "실행 결과";
    private final static String NEXT_LINE = "/n";
    private final static String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String REQUEST_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public void printRequestCarName() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
    }

    public void printRequestRound() {
        System.out.println(REQUEST_ROUND_MESSAGE);
    }

    public void printResult() {
        System.out.println(RACING_RESULT);
    }

    public void printRoundResult(List<CarDto> carDtos) {
        StringBuilder sb = new StringBuilder();
        for (CarDto carDto : carDtos) {
            sb.append(carDto.carName()).append(" : ")
                .append("-".repeat(carDto.position()))
                .append(NEXT_LINE);
        }
        sb.append(NEXT_LINE);
        System.out.println(sb);
    }
}
