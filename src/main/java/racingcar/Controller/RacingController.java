package racingcar.Controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import racingcar.Model.MemberState;
import racingcar.Model.RacingGame;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingController {

    private MemberState memberState;
    private RacingGame racingGame;
    private InputView inputView;
    private OutputView outputView;

    public RacingController() {
        memberState = new MemberState();
        racingGame = new RacingGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void enterGame() {
        Map<String, Integer> memberStates = new LinkedHashMap<>();

        List<String> winner = new ArrayList<>();

        memberStates = memberState.initMemberState(inputView.carNameInputView());

        int tryCount = inputView.getTryCount();

        outputView.printGameResultword();

        gameStart(tryCount, memberStates);

        winner = racingGame.getWinner(memberStates);

        outputView.printWinnerView(winner);
    }

    public void gameStart(int tryCount, Map<String, Integer> memberStates) {
        // 게임 시작
        for (int i = 0; i < tryCount; i++) {
            memberStates = racingGame.startEachGame(memberStates);
            printEachGameResult(memberStates);
            System.out.println();
        }
    }

    public void printEachGameResult(Map<String, Integer> memberStates) {
        for (String name : memberStates.keySet()) {
            // 각 차수별 실행 결과
            System.out.println(name + " : " + racingGame.changeDash(memberStates.get(name)));
        }
    }
}
