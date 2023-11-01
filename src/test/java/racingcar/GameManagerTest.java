package racingcar;

import org.junit.jupiter.api.Test;

class GameManagerTest {


    @Test
    void 게임진행시carName이정상적으로입력된다() {
        //given
        GameManager gameManager = new GameManager(new Input("pobi,race,suhoon"), new Output());
        //when
        gameManager.startGame();


    }
}