package racingcar;

public class RacingGameService {
    private final InputView inputView = new InputView();

    private int getPlayCount(){
        return inputView.playCount();
    }



}
