package racingcar.view;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {}

    public OutputView getInstance(){
        return INSTANCE;
    }
}
