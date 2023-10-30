package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Constant.*;

class CarsTest {

    Car userA;
    Car userB;
    private static final String USER_A = "a";
    private static final String USER_B = "b";

    @BeforeEach
    void setUp() {
        userA = new Car(USER_A);
        userB = new Car(USER_B);
    }

    @Test
    @DisplayName("userA_1점_userB_0점_일때_결과_출력_확인")
    public void getWinnersString_whenUserAPoint1UserBPoint0_Output() {
        //given
        userA.forward();
        Cars cars = new Cars(Lists.list(userA, userB));
        String expected = MESSAGE_WINNER + IS + USER_A;

        //when
        String actual = cars.getWinnersString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("userA_0점_userB_0점_일때_공동_출력_확인")
    public void getWinnersString_whenUserAPoint0UserBPoint0_Output() {
        //given
        Cars cars = new Cars(Lists.list(userA, userB));
        String expected = MESSAGE_WINNER + IS + USER_A + OUTPUT_DELIM + USER_B;

        //when
        String actual = cars.getWinnersString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("userA_1점_userB_0점_일때_toString()_확인")
    public void toString_whenUserAPoint1UserBPoint0_Output() {
        //given
        userA.forward();
        Cars cars = new Cars(Lists.list(userA, userB));
        String expected = USER_A + IS + LINE + "\n" +
                USER_B + IS + "\n";

        //when
        String actual = cars.toString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("인자로_비어있는_list_전달시_Cars_객체생성_에러_확인")
    public void constructor_whenListIsEmpty_IllegalArgumentException() {
        //given
        List<Car> emptyList = new ArrayList<>();

        //when & then
        Assertions.assertThatThrownBy(() -> new Cars(emptyList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_EMPTY_CAR_LIST);
    }
}