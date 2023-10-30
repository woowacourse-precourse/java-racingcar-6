package racingcar.view;

import java.util.List;

import racingcar.dto.CarDto;
import racingcar.dto.RoundResultDto;

public class OutputView {

    private static final String NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_INPUT_GUIDE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_GUIDE = "실행 결과";
    private static final String COLON_DELIMITER = " : ";
    private static final String HYPHEN = "-";
    private static final String WINNERS_GUIDE = "최종 우승자";
    private static final String COMMA_DELIMITER = ", ";

    public void printNamesGuide() {
        System.out.println(NAMES_INPUT_GUIDE);
    }

    public void printTrialGuide() {
        System.out.println(TRIAL_INPUT_GUIDE);
    }

    public void printResultGuide() {
        System.out.println();
        System.out.println(RESULT_GUIDE);
    }

    public void printRoundResult(final RoundResultDto roundResultDto) {
        List<CarDto> carDtos = roundResultDto.carDtos();
        for (CarDto carDto : carDtos) {
            String carName = carDto.name();
            String currentPosition = replaceToHyphens(carDto.position());
            System.out.println(String.join(COLON_DELIMITER, carName, currentPosition));
        }
        System.out.println();
    }

    private String replaceToHyphens(final int position) {
        return HYPHEN.repeat(position);
    }

    public void printWinnersName(final List<String> winnersName) {
        System.out.println(String.join(COLON_DELIMITER, WINNERS_GUIDE, divideNamesByComma(winnersName)));
    }

    private String divideNamesByComma(final List<String> names) {
        return String.join(COMMA_DELIMITER, names);
    }

}
