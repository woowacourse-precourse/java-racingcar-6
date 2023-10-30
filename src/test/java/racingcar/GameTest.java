package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    public void Game_생성(){
        String[] cars = {"hans", "jins"};
        Game gm = new Game(cars, 1);
        for (int i = 0; i < cars.length; i++){
            assertThat(gm.players[i].name).isEqualTo(cars[i]);
            assertThat(gm.players[i].location).isEqualTo(0);
        }
    }

    @Test
    public void Game_play의_테스트(){
        String[] cars = {"hans", "jins"};
        Game gm = new Game(cars, 1);
        gm.play(gm);

        for (int i=0; i<cars.length; i++){
            System.out.println(i+"번 자동차의 이름 : "+gm.players[i].name);
            System.out.println(i+"번 자동차의 위치 : "+gm.players[i].location);
        }
    }
}