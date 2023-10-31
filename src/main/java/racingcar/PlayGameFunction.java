package racingcar;

import java.util.List;

public class PlayGameFunction {
    public PlayGameFunction() {
    }

    public void PlayGame(List<Integer> UserRace, InputResultModel inputData) {
        for (int i = 0; i < inputData.getNumberOfTime(); i++) {
            RandomFunction randomFunction = new RandomFunction();
            randomFunction.CreateRandomFunction(UserRace, UserRace.size());
            PlayView playView = new PlayView();
            playView.PlayResultView(UserRace, inputData, i);
        }
    }
}
