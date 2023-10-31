package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.vo.CarName;

public class OutputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String LINE = "\n";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String SEPARATOR_COLON = " : ";
    private static final String POSITION_CHARACTER = "-";
    private static final String WINNER_INFO_MESSAGE = "최종 우승자";
    private static final String COMMA_SEPARATOR = ", ";

    public void printRequestCarNameMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printRequestTryNumberMessage() {
        System.out.println(TRY_NUMBER_INPUT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(LINE + RESULT_MESSAGE);
    }

    public void printResult(List<CarDto> carDtoList) {
        carDtoList.stream().forEach(carDto -> {
            String carName = carDto.getCarName();
            String carPosition = POSITION_CHARACTER.repeat(carDto.getPosition());
            System.out.println(carName + SEPARATOR_COLON + carPosition);
        });

        System.out.println();
    }

    public void printWinners(List<CarName> winnerNames) {
        String result = winnerNames.stream()
                .map(CarName::name)
                .collect(Collectors.joining(COMMA_SEPARATOR));

        System.out.print(WINNER_INFO_MESSAGE + SEPARATOR_COLON + result);
    }
}
