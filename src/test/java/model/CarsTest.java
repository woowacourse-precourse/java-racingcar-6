package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("가장 많이 움직인 자동차 여럿 테스트")
    public void 가장_많이_움직인_자동차_테스트() {
        //given
        String[] names = {"tree", "pine", "ant"};
        Cars cars = new Cars(names);

        //when
        String[] winner = cars.winner();

        //then
        assertThat(winner).isEqualTo(new String[]{"tree", "pine", "ant"});
    }

    @Test
    @DisplayName("가장 많이 움직인 자동차 pine인지")
    public void 가장_많이_움직인_자동차는_pine_테스트() {
        //given
        String[] names = {"tree", "pine", "ant"};
        Cars cars = new Cars(names);
        
        //when
        cars.indexAt(1).increaseMovingCountIfGreater(4, 9);
        String[] winner = cars.winner();

        //then
        assertThat(winner).isEqualTo(new String[]{"pine"});
    }
}
