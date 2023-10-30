package racingcar.view;

public class RaceView {
    private InputView inputView;
    private OutputView outputView;

    public RaceView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void displayCarNameInputNotice() {
        outputView.displayCarNameInputNotice();
    }

    public String[] getCarNamesFromUsers() {
        return inputView.getCarNamesFromUsers();
    }

    public void displayMoveCountInputNotice() {outputView.displayMoveCountInputNotice();}

    public String getMoveCountFromUsers() {
        return inputView.getMoveCountFromUsers();}
}
