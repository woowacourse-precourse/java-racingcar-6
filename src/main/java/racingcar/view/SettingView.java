package racingcar.view;

public class SettingView {
    private static final String INPUT_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_NUMBER_MSG = "시도할 회수는 몇회인가요?";

    public void printInputCarNameMsg(){
        System.out.println(INPUT_CAR_NAME_MSG);
    }

    public void printInputRoundNumberMsg(){
        System.out.println(INPUT_ROUND_NUMBER_MSG);
    }
}
