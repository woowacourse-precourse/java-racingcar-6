package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private final String APPLICANT_VIEW = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String RACE_COUNT_VIEW = "시도할 회수는 몇회인가요?";

    public String showApplicantView() {
        System.out.println(APPLICANT_VIEW);
        String carNames = Console.readLine();
        // validate 로직
        return carNames;
    }

    public int showRaceCountView() {
        System.out.println(RACE_COUNT_VIEW);
        String raceCount = Console.readLine();
        // validate 로직
        return Integer.parseInt(raceCount);
    }


}
