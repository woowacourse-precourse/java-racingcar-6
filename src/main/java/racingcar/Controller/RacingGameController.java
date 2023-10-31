package racingcar.Controller;

import racingcar.Model.RacingGameModel;
import racingcar.Model.RacingGameStateModel;
import racingcar.View.RacingGameInputView;
import racingcar.View.RacingGameOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                int dice = DiceUtils.getDiceRoLl(DICE_MIN, DICE_MAX);
                stateModel.updateGameState(name,dice);
                stateModel.updateForwardState(name, dice);
            }
        }
    }

    public void runGame() {
        // 1. 시작 데이터 초기화
        // 자동차 이름 목록 초기화
        String nameInputs = inputView.nameInput();
        List<String> names = InputConverter.convertStringToNames(nameInputs);

        // 시도 횟수 초기화
        String turnInput = inputView.turnsInput();
        int turns = InputConverter.convertStringToTurns(turnInput);

        // 2. 모델 초기화
        model.setGameNames(names);
        model.setGameTurns(turns);

        // 3. 게임 실행
        gameLogic(names, turns);

        // 4. 결과 출력
        outputView.gameProcessView(stateModel.getForwardState(), turns);

        // 5. 우승자 결정
        List<String> winners = determineWinners(stateModel.getForwardState());

        // 6. 최종 우승자 출력
        outputView.gameWinnerView(winners);
    }

    public List<String> determineWinners(Map<String, List<Integer>> forwardState) {
        int max = 0;
        int te = 0;
        List<String> winners = new ArrayList<>();

        for(Map.Entry<String, List<Integer>> entry:forwardState.entrySet()) {
            List<Integer> lt = entry.getValue();
            te = lt.get(lt.size() - 1);
            if (max < te) {        // 최대 값이랑 작거나 같음(
                max = te;
                winners.clear();
                winners.add(entry.getKey());
            }else if(max == te) {
                winners.add(entry.getKey());
            }
        }

        return winners;
    }
}
