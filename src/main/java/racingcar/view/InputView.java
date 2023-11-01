package racingcar.view;

public class InputView {

    private InputView() {
    }

    public static void requestCarName() {
        System.out.println(ViewMessage.INPUT_NAME.getMessage());
    }

    public static void requestNumberOfGameCount() {
        System.out.println(ViewMessage.INPUT_NUMBER_OF_TIMES.getMessage());
    }


}
