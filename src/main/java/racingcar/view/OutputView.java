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
                        carDto.getName() + SEPARATOR_COLON + STEP_CHARACTER.repeat(carDto.getStep())));

        System.out.println();
    }
}
