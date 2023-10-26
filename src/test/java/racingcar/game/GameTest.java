package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void nameLengthTest(){
        MiniGame miniGame = new MiniGame();

        Assertions.assertThat(miniGame.checkNameLength("    ")).isEqualTo(false);
        Assertions.assertThat(miniGame.checkNameLength("asdasdf")).isEqualTo(false);
        Assertions.assertThat(miniGame.checkNameLength("asd")).isEqualTo(true);
    }

    static class MiniGame{
        boolean checkNameLength(String name){
            String removeSpace = name.trim();
            if(removeSpace.length()<=5 && removeSpace.length()>=1){
                return true;
            }
            return false;
        }
    }
}
