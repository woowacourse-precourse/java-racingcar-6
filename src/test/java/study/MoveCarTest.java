package study;

import org.junit.jupiter.api.Test;
import racingcar.Object.InputManager;
import racingcar.game.Game;
import racingcar.game.GameCar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveCarTest {


    @Test
    void 차_이동_테스트() {
        //given
        GameCar gameCar = new GameCar("choi");
        //when
        gameCar.move();
        //then
        assertThat(gameCar.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값에따라_차_이동_테스트(){
        //given
        List<String> carNameList = InputManager.parseCarName("choi,jong,geun");
        Game game = new Game(1,carNameList);
        int turn = InputManager.parseIntTurnAnswer("5");
        game = new Game(turn,carNameList);

        //when
        game.moveGameCars();

        //then;
        List<Integer> gameScore = game.getGameScore();
        System.out.println(gameScore.get(0));
        System.out.println(gameScore.get(1));
        System.out.println(gameScore.get(2));
    }
}
