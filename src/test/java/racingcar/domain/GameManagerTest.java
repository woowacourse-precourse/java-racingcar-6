package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameManagerTest{

    private GameManager gameManager;

    @BeforeEach
    void init(){
        gameManager = new GameManager();
    }

    @Test
    @DisplayName("입력받은 문자열을 쉼표 기준으로 구분하여 자동차 목록을 반환한다.")
    void 입력받은_문자열을_쉼표_기준으로_구분하여_자동차_목록_반환(){
        //given
        String input = "pobi,woni,jun";
        int initialForwardCount = 0;
        String name1 = "pobi";
        String name2 = "woni";
        String name3 = "jun";

        //when
        List<Car> cars = gameManager.askInput();
        Mockito.when(readLine()).thenReturn(input);

        //then
        assertThat(cars).hasSize(3)
                .extracting(Car::getForwardCount, Car::getName)
                .contains(
                        tuple(
                                name1, initialForwardCount
                        ),
                        tuple(
                                name2, initialForwardCount
                        ),
                        tuple(
                                name3, initialForwardCount
                        )
                );

    }

}
