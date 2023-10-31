package racingcar.view;

import java.util.List;
import java.util.Map;

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

    public void displayRaceStatus(List<Map<String, Integer>> result) {
        outputView.displayRaceStatus(result);
    }

    public void displayWinners(List<String> winners) {
        outputView.displayWinners(winners);}
}
