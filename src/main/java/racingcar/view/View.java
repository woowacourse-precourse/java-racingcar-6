package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    private final static String START_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String GAME_TRY_TEXT = "시도할 회수는 몇회인가요?";
    private final static String GAME_RESULT_TEXT = "실행 결과";
    private final static String CHAMPION_TEXT = "최종 우승자 : ";

    public String driverInjectionView() {
        System.out.println(START_TEXT);
        return (readLine());
    }

    public String roundInjectionView() {
        System.out.println(GAME_TRY_TEXT);
        return readLine();
    }

    public void roundResultTitleView() {
        System.out.println("\n" + GAME_RESULT_TEXT);
    }

    public void roundResultView(String roundResult) {
        System.out.println(roundResult);
    }

    public void championView(String champion) {
        System.out.println(CHAMPION_TEXT + champion);
    }
}