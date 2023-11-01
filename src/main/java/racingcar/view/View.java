package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import racingcar.validation.Validation;

public class View {

    private final String APPLICANT_VIEW = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String RACE_COUNT_VIEW = "시도할 회수는 몇회인가요?";
    private final String RACE_RESULT_HEADER = "실행 결과";
    private final String ROUND = "ROUND";

    public String showApplicantView() {
        System.out.println(APPLICANT_VIEW);
        String carNames = Console.readLine();

        Validation.validateApplicantCars(carNames);
        return carNames.trim();
    }

    public int showRaceCountView() {
        System.out.println(RACE_COUNT_VIEW);
        String raceCount = Console.readLine().trim();

        Validation.validateRaceCount(raceCount);
        return Integer.parseInt(raceCount);
    }

    public void showRaceResultHeader() {
        System.out.println(RACE_RESULT_HEADER);
    }

    public void showRoundResultView(Map<String, Integer> roundResult) {
        StringBuffer result = new StringBuffer();
        roundResult.forEach((carName, position) -> {
            result.append(carName + " : " + "-".repeat(position) + "\n");
        });
        System.out.println(result.toString());
        System.out.println();
    }

    public void showWinnerView(List<String> winners) {
        StringBuffer result = new StringBuffer();

        winners.forEach(winner -> {
            result.append(winner);
            result.append(", ");
        });
        result.setLength(result.length() - 2);

        System.out.println("최종 우승자 : " + result.toString());
    }
}