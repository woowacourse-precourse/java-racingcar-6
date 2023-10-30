package racingcar.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Domain.CarGroup;

class GameModelTest {

    GameModel gameModel = new GameModel();
    @Test
    @DisplayName("게임 한판 진행하기")
    void playGameRound() {
        //given
        CarGroup testCarGroup = CarGroup.of(List.of("testCar1", "testCar2", "testCar3"));

        //when
        CarGroup afterPlayGame = gameModel.playGameRound(testCarGroup);

        //then
        Assertions.assertThat(afterPlayGame).isNotNull();
    }

    @Test
    @DisplayName("자동차 이동 여부 판단하기")
    void determineMove() {
        Boolean result = gameModel.determineMove();

        assertNotNull(result);
    }
}