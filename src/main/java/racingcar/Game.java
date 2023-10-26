package racingcar;

import player.Player;
import user.User;
import utils.JoinComma;
import utils.RandomNumber;

import java.util.*;

public class Game {
    User user;
    List<String> players;

    public Game() {
        this.user = new User();
        this.players = User.playerInput();
    }

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        System.out.println(JoinComma.playerInput(this.players));
        System.out.println("시도할 회수는 몇회인가요?");
        String moveNumber = User.moveNumberInput();
        System.out.println(moveNumber + "\n");

        List<Player> playerObjects = new ArrayList<>();
        for (String player : this.players) {
            Player car = new Player(player);
            playerObjects.add(car);
        }
        for (int move = 0; move < Integer.parseInt(moveNumber); move++) {
            for (Player car : playerObjects) {
                car.move(RandomNumber.create());
                System.out.println(car.getPlayerName() + " : " + "-".repeat(car.getDist()));
            }
            System.out.println();
        }
        // HashMap의 입력 순서를 보장하기 위해서 LinkedHashMap 사용
        Map<String, Integer> playerAndDistMap = new LinkedHashMap<>();
        for (Player car : playerObjects) {
            playerAndDistMap.put(car.getPlayerName(), car.getDist());
        }
        int maxDist = Collections.max(playerAndDistMap.values());

        System.out.print("최종 우승자 : ");
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : playerAndDistMap.entrySet()) {
            if (entry.getValue() == maxDist) {
                winners.add(entry.getKey());
            }
        }
        System.out.print(JoinComma.winnerOutput(winners));
    }
}
