package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.view.Input;

public class GameManagerTest {

    @Test
    @DisplayName("게임 시작 전 게임 진행을 위한 요소들을 세팅 테스트")
    void gameSetting_test(){
        GameManager gameManager = new GameManager();
        Input input = Mockito.mock(Input.class);
        gameManager.input = input;

        when(gameManager.input.getCarNameList()).thenReturn(Arrays.asList("pobi","jun","woni"));
        when(gameManager.input.getTryCount()).thenReturn(5);
        gameManager.gameSetting();

        assertThat(gameManager.gameElements.getCarNameList()).isEqualTo(Arrays.asList("pobi","jun","woni"));
        assertThat(gameManager.gameElements.getTryCount()).isEqualTo(5);
        assertThat(gameManager.gameElements.getCarMap()).hasSize(3)
                .contains(entry("pobi", 0), entry("jun", 0), entry("woni", 0));
    }


}
