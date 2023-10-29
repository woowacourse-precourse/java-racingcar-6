package racingcar.view;

import java.util.List;

import racingcar.dto.RoundResult;
import racingcar.dto.RoundResultDto;

public class OutputView {

    private static final String NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_INPUT_GUIDE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_GUIDE = "실행 결과";
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
        System.out.println(RESULT_GUIDE);
    }

    public void printRoundResult(final RoundResultDto roundResultDto) {
        List<RoundResult> roundResults = roundResultDto.roundResults();
        for (RoundResult roundResult : roundResults) {
            String carName = roundResult.name();
            String currentPosition = replaceTo(roundResult.position());
            System.out.println(String.join(" : ", carName, currentPosition));
        }
        System.out.println();
    }

    private String replaceTo(final int position) {
        return HYPHEN.repeat(position);
    }

    public void printWinnersName(List<String> winnersName) {
        System.out.println(String.join(" : ", WINNERS_GUIDE, divideByComma(winnersName)));
    }

    private String divideByComma(List<String> winnersName) {
        return String.join(COMMA_DELIMITER, winnersName);
    }

}
