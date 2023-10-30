package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    @DisplayName("생성자에 List<Winner>를 주고 메소드로 그 Winner들의 이름List를 콤마로 구분하여 반환")
    void makeWinnerListTest() {
        //given
        List<Winner> winnerList = List.of(new Winner("test1"), new Winner("test2"), new Winner("test3"));
        Winners winners = new Winners(winnerList);

        //when
        String result = winners.makeWinnerList();

        //then
        assertThat(result).isEqualTo("test1, test2, test3");
    }
}
