package racingcar.view;

public class InputFormView {
    private static final String CAR_INPUT_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_NUM_INPUT_REQUEST = "시도할 회수는 몇회인가요?";

    public static void viewCarInputForm() {
        System.out.println(CAR_INPUT_REQUEST);
    }

    public static void viewTryNumInputForm() {
        System.out.println(TRY_NUM_INPUT_REQUEST);
    }
}
