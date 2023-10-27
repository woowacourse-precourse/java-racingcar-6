package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Player> players = Arrays.asList(new Player("honi"), new Player("jun"), new Player("woni"));

        System.out.println("실행 결과");
        for (int i = 0; i < 5; i++) {
            for (Player player: players) {
                player.run();
                player.print();
            }
            System.out.println();
        }
    }
}
