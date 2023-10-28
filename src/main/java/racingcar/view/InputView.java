package racingcar.view;

public class InputView {

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if(instance == null)
            instance = new InputView();
        return instance;
    }


}
