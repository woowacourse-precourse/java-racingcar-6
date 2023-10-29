package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.logic.RacingGameLogic;
import racingcar.logic.WinnnerLogic;
import racingcar.repository.Player;
import racingcar.repository.PlayerRepository;
import racingcar.validation.Validation;

public class User {
    private final PlayerRepository playerRepository = new PlayerRepository();
    private final RacingGameLogic racingGameLogic = new RacingGameLogic();
    private final WinnnerLogic winnnerLogic = new WinnnerLogic();
    private final Validation validation = new Validation();

    public void run() {
        inputPlayer();
    }

    public void inputPlayer() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerName = Console.readLine();
        ArrayList<String> players = new ArrayList<>();
        String[] comma = playerName.split(",");
        for (int i = 0; i < comma.length; i++) {
            validation.playerNameValidation(comma[i]);
            players.add(comma[i]);
        }

        for (int i = 0; i < players.size(); i++) {
            Player racingPlayer = new Player(players.get(i), 0);
            playerRepository.save(racingPlayer);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        System.out.println("실행 결과");
        Map<String, Integer> updatedPlayers = racingGameLogic.forwardLogic(playerRepository.getPlayers(), tryCount);
        List<String> winners = winnnerLogic.finalWinner(updatedPlayers);

        String result = String.join(",", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
