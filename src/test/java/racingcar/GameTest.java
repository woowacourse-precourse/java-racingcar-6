package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void 랜덤숫자가_4이상이면_distance증가_테스트(){
        Game game = new Game();
        int result = game.forward(5, 0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 랜덤숫자가_4이하면_distance변화없음_테스트(){
        Game game = new Game();
        int result = game.forward(3, 0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 게임테스트(){

    }
}
