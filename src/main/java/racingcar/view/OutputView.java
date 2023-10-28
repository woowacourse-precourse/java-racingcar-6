package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    private static final String CAR_NAME_INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_COUNT_INPUT_MSG = "시도할 회수는 몇회인가요?";
    private static final String LINE = "\n";
    private static final String RESULT_MSG = LINE + "실행 결과";
    private static final String SEPARATOR_COLON = " : ";
    private static final String STEP_CHARACTER = "-";
    private static final String WINNER_INFO_MSG = "최종 우승자";
    private static final String COMMA_SEPARATOR = ", ";

    public void printRequestCarNameMessage() {
        System.out.println(CAR_NAME_INPUT_MSG);
    }

    public void printRequestCountMessage() {
        System.out.println(TRIAL_COUNT_INPUT_MSG);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MSG);
    }

    public void printResult(List<CarDto> carDtoList) {
        carDtoList.forEach(
                carDto -> System.out.println(
                        carDto.name() + SEPARATOR_COLON + STEP_CHARACTER.repeat(carDto.step())));

        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String result = String.join(COMMA_SEPARATOR, winners);
        System.out.print(WINNER_INFO_MSG + SEPARATOR_COLON + result);
    }
}
