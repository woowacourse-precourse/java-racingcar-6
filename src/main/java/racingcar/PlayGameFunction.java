package racingcar;

import java.util.List;

public class PlayGameFunction {
    public PlayGameFunction() {
    }
    public void PlayGame(List<Integer> UserRace, List <String> inputDataList, int NumberOfTime){
        for(int i = 0; i < NumberOfTime; i++){
            RandomFunction randomFunction = new RandomFunction();
            randomFunction.CreateRandomFunction(UserRace, UserRace.size());
            PlayView playView = new PlayView();
            playView.PlayResultView(UserRace, inputDataList, NumberOfTime, i);
        }
    }
}
