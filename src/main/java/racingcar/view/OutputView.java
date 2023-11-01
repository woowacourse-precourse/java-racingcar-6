package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.dto.CarDto;

public class OutputView {

    private static final String PROMPT_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static final String PROMPT_RUN_RESULT_TITLE = "실행 결과";
    private static final String PROMPT_FINAL_WINNER_TITLE = "최종 우승자 : ";
    private static final String DELIMITER_OF_WINNER = ", ";
    private static final String CAR_INFO_FORMAT = "%s : %s\n";
    private static final String LOCATION_FORMAT = "-";


    public void displayInputCarNames() {
        System.out.println(PROMPT_INPUT_CAR_NAMES);
    }

    public void displayInputNumberOfAttempts() {
        System.out.println(PROMPT_INPUT_NUMBER_OF_ATTEMPTS);
    }

    public void displayRoundResultHeader() {
        System.out.println();
        System.out.println(PROMPT_RUN_RESULT_TITLE);
    }

    public void displayRoundResult(List<CarDto> gameStatus) {
        String resultText = gameStatus.stream().map(this::convertCarToString).collect(Collectors.joining());
        System.out.println(resultText);
    }

    private String convertCarToString(CarDto car) {
        String location = LOCATION_FORMAT.repeat(car.location());
        return CAR_INFO_FORMAT.formatted(car.name(), location);
    }

    public void displayFinalWinner(String winner) {
        System.out.print(PROMPT_FINAL_WINNER_TITLE);
        System.out.println(winner);
    }
}
