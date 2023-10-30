package study;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Model.Cars;
import racingcar.Model.GameModel;

public class GameModelTest {
    GameModel gameModel = new GameModel();
    Cars player1 = new Cars("kim");
    Cars player2 = new Cars("lee");
    Cars player3 = new Cars("park");

    @Test
    void 최종우승자_Test() {
        for (int i = 0; i < 2; i++) { // kim 2번 전진
            player1.goOneStep();
        }

        for (int i = 0; i < 3; i++) { // lee 3번 전진
            player2.goOneStep();
        }

        for (int i = 0; i < 5; i++) { // park 5번 전진
            player3.goOneStep();
        }

        ArrayList<Cars> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        ArrayList<String> winner = gameModel.decideFinalWinner(players);

        ArrayList<String> answer = new ArrayList<>();
        answer.add("park");

        Assertions.assertThat(winner).isEqualTo(answer);
    }


}
