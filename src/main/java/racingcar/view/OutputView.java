package racingcar.view;

public class OutputView {
    private final static String PROMPT_ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static void printCarNamePrompt(){
        System.out.println(PROMPT_ENTER_CAR_NAMES);
    }

}
