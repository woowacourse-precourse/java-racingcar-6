package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private final String APPLICANT_VIEW = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String showApplicantView() {
        System.out.println(APPLICANT_VIEW);
        String carNames = Console.readLine();
        return carNames;
    }
}
