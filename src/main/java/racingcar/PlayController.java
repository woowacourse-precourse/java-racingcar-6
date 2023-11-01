package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class PlayController {
    // 자동차 이름 부여
    public List<String> generateRacingCarName() {
        //System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> players = new ArrayList<>();

        String inputPlayers = Console.readLine();

        String[] playersTemp = inputPlayers.split(",");

        players.addAll(Arrays.asList(playersTemp));
        return players;
    }

    public void movingCar(List<String> players, List<Integer> randomNumbers, List<Integer> positions) {
        for (int i = 0; i < players.size(); i++) {
            if (randomNumbers.get(i) > 3) {
                int newPosition = positions.get(i) + 1;
                positions.set(i, newPosition);
            }
        }
    }

    public String winPlayers(List<String> players, List<Integer> positions) {
        List<String> winnerPlayers = new ArrayList<>();
        int winnerPosition = Collections.max(positions);

        for (int i = 0; i < positions.size(); i++) {
            if (winnerPosition == positions.get(i)) {
                winnerPlayers.add(players.get(i));
            }
        }

        String winnerMessage = "최종 우승자 : " + String.join(", ", winnerPlayers);

        System.out.println(winnerMessage);
        return winnerMessage;
    }
}