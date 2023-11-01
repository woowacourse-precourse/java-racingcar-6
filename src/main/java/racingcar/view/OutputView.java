package racingcar.view;
import static racingcar.Config.*;

public class OutputView {


    public void gameStart(){
        System.out.printf(GAME_START_MESSAGE);
    }

    public void roundInputMessage(){
        System.out.printf(Round_Input_MESSAGE);
    }

    public void ResultMessage(){
        System.out.printf(Result_MESSAGE);
    }
}
