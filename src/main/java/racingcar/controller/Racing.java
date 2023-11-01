package racingcar.controller;

import java.util.List;
import racingcar.common.type.TrialCount;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.WinnerDTO;
import racingcar.view.OutputView;

/**
 * 레이싱 게임을 진행하는 컨트롤러 클래스
 */
public class Racing {
    private final Game game;
    private final Result result;

    private Racing(Game game, Result result) {
        this.game = game;
        this.result = result;
    }


    //Racing 객체를 생성하여 반환
    public static Racing of(Game game, Result result) {
        return new Racing(game, result);
    }

    /**
     * 레이싱 게임을 시작
     *
     * @param trialCount 게임을 시도할 횟수
     */
    public void start(TrialCount trialCount) {
        List<AllRoundDTO> allRoundResults = playGame(trialCount);
        WinnerDTO winnerDTO = announceResult();

        displayResults(allRoundResults, winnerDTO);
    }

    // 게임을 진행하고 결과를 반환
    private List<AllRoundDTO> playGame(TrialCount trialCount) {
        return game.play(trialCount);
    }

    // 게임의 최종 결과를 발표
    private WinnerDTO announceResult() {
        return result.announce();
    }

    // 게임의 모든 결과를 출력
    private void displayResults(List<AllRoundDTO> allRoundResults, WinnerDTO winnerResults) {
        OutputView.printAllRoundResults(allRoundResults);
        OutputView.printWinner(winnerResults);
    }
}
