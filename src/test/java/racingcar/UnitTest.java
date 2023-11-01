package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.car.Car;
import racingcar.util.InputUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {

    @Test
    public void strToList(){
        String input = "a,b,c,d,";
        List<String> expected = List.of("a","b","c","d");

        List<String> actual = InputUtil.inputNames(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void strToListForException(){
        String input = "abcdef,ab,abcd";
        assertThatThrownBy(() -> InputUtil.inputNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다!");
    }


    @Test void jumpTest(){
        Mockito.mockStatic(Randoms.class);
        Car car = new Car("test");
        int beforeDist = car.getDist();

        Mockito.when(Randoms.pickNumberInRange(0, 9)).thenReturn(5);

        car.jump();
        assertEquals(beforeDist + 1, car.getDist());

        beforeDist = car.getDist();

        Mockito.when(Randoms.pickNumberInRange(0, 9)).thenReturn(3);

        car.jump();
        assertEquals(beforeDist, car.getDist());
    }
}
