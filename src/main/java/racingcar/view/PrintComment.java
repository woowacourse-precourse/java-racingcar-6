package racingcar.view;

public class PrintComment {
    private static final String INIT_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_COMMENT = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    public static void printInitComment(){
        System.out.println(INIT_COMMENT);
    }

    public static void printTrialComment(){
        System.out.println(TRIAL_COMMENT);
    }

    public static void printResultComment(){
        System.out.println(GAME_RESULT);
    }

}
