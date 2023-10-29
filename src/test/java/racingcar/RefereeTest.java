package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    @Test
    public void Referee_우승자발표_테스트(){
        String[] cars = {"hans", "jins"};
        Game nowGame = new Game(cars, 0);
        nowGame.players[0].location = 3;
        nowGame.players[1].location = 2;

        Referee rf = new Referee();
        assertThat(rf.announceWinner(nowGame)).isEqualTo("hans");
    }

    @Test
    public void Referee_중복_우승자발표_테스트(){
        String[] cars = {"hans", "jins"};
        Game nowGame = new Game(cars, 0);
        nowGame.players[0].location = 3;
        nowGame.players[1].location = 3;

        Referee rf = new Referee();
        assertThat(rf.announceWinner(nowGame)).contains("hans", "jins");
        System.out.println(rf.announceWinner(nowGame));
    }
}