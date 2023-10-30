package racingcar.Controller;

import racingcar.Model.RacingGameModel;
import racingcar.Model.RacingGameStateModel;
import racingcar.View.RacingGameInputView;
import racingcar.View.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    private RacingGameModel model = new RacingGameModel();
    private RacingGameStateModel stateModel = new RacingGameStateModel();
    private RacingGameInputView inputView = new RacingGameInputView();
    private RacingGameOutputView outputView = new RacingGameOutputView();
    private static final int DICE_MIN = 0;
    private static final int DICE_MAX = 9;

    // 게임 진행
    public void gameLogic(List<String> inputs, int turns) {
        // 3. 경주 진행
        for(int i = 0; i < turns; i++) {
            for(String name: inputs){
                // 무작위값 계산
                int dice = DiceUtils.getDiceRool(DICE_MIN, DICE_MAX);
                stateModel.updateGameState(name,dice);
                stateModel.updateForwardState(name, dice);
            }
        }
    }

    public void runGame() {
        // 뷰에서 입력
        String nameInputs = inputView.nameInput();
        String turnInput = inputView.turnsInput();

        List<String> names = InputConverter.nameInputCvt(nameInputs);
        int turns = InputConverter.turnsInputCnt(turnInput);

        // 모델 초기화
        model.setGameNames(names);
        model.setGameTurns(turns);

        // 3. 게임 실행
        gameLogic(names, turns);

        // 4. 결과 출력
        outputView.gameProcessView(stateModel.getForwardState(), turns);

        // 5. 우승자 출력
        outputView.gameWinnerView(stateModel.getForwardState());
    }
}
