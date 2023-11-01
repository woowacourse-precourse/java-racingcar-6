package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.car.Car;
import racingcar.car.Track;
import racingcar.util.InputUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest extends NsTest {

    @Test
    public void strToList() {
        String input = "a,b,c,d,";
        List<String> expected = List.of("a", "b", "c", "d");

        List<String> actual = InputUtil.inputNames(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void strToListForException() {
        String input = "abcdef,ab,abcd";
        assertThatThrownBy(() -> InputUtil.inputNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다!");
    }


    @Test
    public void jumpTest() {
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

        Mockito.clearAllCaches();
    }


    @Test
    public void pickTest() {
        Track track = Track.getInstance();

        track.setCars(List.of("a", "b", "c"));

        Mockito.mockStatic(Randoms.class);

        Mockito.when(Randoms.pickNumberInRange(0, 9)).thenReturn(3, 4, 5);

        track.runCars();

        track.print1st();

        assertThat(output()).contains("c").contains("b");

        Mockito.clearAllCaches();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
