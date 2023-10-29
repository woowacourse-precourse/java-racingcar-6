package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import racingcar.dto.CarsDto;

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

    public void printRoundResult(final CarsDto carsDto) {
        Map<String, Integer> roundResult = carsDto.carsStatus();
        for (Entry<String, Integer> entry : roundResult.entrySet()) {
            String name = entry.getKey();
            String position = replaceTo(entry.getValue());
            System.out.println(String.join(" : ", name, position));
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
