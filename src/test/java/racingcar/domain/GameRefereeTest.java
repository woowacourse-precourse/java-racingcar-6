package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRefereeTest {

    private String name1;

    private String name2;

    private String name3;

    @BeforeEach
    public void setUp() {
        name1 = "pobi";
        name2 = "jason";
        name3 = "hihi";
    }

    @DisplayName("게임 결과 도출 : 3명 공동 우승")
    @Test
    public void totalGame() throws Exception {
        //given
        int repeat = 3;
        int movableValue = 4;
        GameReferee referee = new GameReferee();
        Cars cars = new Cars(List.of(name1, name2, name3));

        for (int i = 0; i < repeat; i++) {
            cars.tryToMove(() -> movableValue);
        }

        //when
        GameResult gameResult = referee.totalGame(cars);

        //then
        assertThat(gameResult.toString()).isEqualTo("최종 우승자 : pobi, jason, hihi");
     }
}