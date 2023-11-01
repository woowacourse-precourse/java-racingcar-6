package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.logic.InputPlayerData;
import racingcar.logic.InputTryCount;
import racingcar.logic.RacingGameLogic;
import racingcar.logic.WinnerLogic;
import racingcar.repository.SavaPlayersData;

public class GameStart {
    RacingGameLogic racingGameLogic = new RacingGameLogic();
    WinnerLogic winnerLogic = new WinnerLogic();
    InputPlayerData inputPlayerData = new InputPlayerData();

    SavaPlayersData savaPlayersData = new SavaPlayersData();
    InputTryCount inputTryCount = new InputTryCount();

    public void run() {
        gameStart();
    }

    public void gameStart() {
        ArrayList<String> players = inputPlayerData.inputData();
        Map<String, Integer> savePlayers = savaPlayersData.savePlayers(players);
        int tryCount = inputTryCount.tryCount();

        System.out.println("실행 결과");
        Map<String, Integer> updatedPlayers = racingGameLogic.forwardLogic(savePlayers, tryCount);
        List<String> winners = winnerLogic.finalWinner(updatedPlayers);

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
