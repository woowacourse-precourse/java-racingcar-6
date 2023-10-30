package racingcar;

public class RacingGameService {
    private final InputView inputView = new InputView();

    private int playCount(){
        return inputView.playCount();
    }

}
