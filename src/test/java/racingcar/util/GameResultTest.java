package racingcar.util;

import static racingcar.util.GameResult.getInstance;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @AfterEach
    void clear() {
        GameResult instance = getInstance();
        instance.setZeroLengthToClear();
    }
    @DisplayName("싱글톤 객체를 호출한다")
    @Test
    void callSingleton() {
        //given
        GameResult instance = getInstance();

        //when
        StringBuilder gameResult = instance.getGameResult();
        StringBuilder gameResult2 = instance.getGameResult();
        gameResult.append("게임");

        //then
        Assertions.assertThat(gameResult).isEqualTo(gameResult2);
    }

    @DisplayName("싱글톤 객체 내부의 값은 같다")
    @Test
    void sameAsSingletonElement() {
        //given
        GameResult instance = getInstance();

        //when
        StringBuilder gameResult = instance.getGameResult();
        StringBuilder gameResult2 = instance.getGameResult();
        gameResult.append("게임");

        //then
        Assertions.assertThat(gameResult.toString()).isEqualTo(gameResult2.toString());
    }

    @DisplayName("싱글톤 객체 호출시 내부 값은 비어있다.")
    @Test
    void callEmptySingleton() {
        //given
        GameResult instance = getInstance();

        //when
        StringBuilder gameResult = instance.getGameResult();

        //then
        Assertions.assertThat(gameResult.toString()).isEqualTo("");
    }
}
