package racingcar.play.car;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Application;

class CarTest extends NsTest{

    @Test
    void 자동차_이름_정상(){
        //given
        String input = "Car1,Car2,Car3";

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        mockStatic(Console.class);
        when(Console.readLine()).thenReturn(input);

        //when

        String[] result = Car.input();

        //then
        String[] expected = {"Car1", "Car2", "Car3"};
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void 자동차_이름_5자리_초과(){
        //given
        String input = "abcdef";
        String count = "1";
        //when

        //then
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input, count))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백_포함(){
        //given
        String input = "abcd, test, test";
        String count = "1";
        //when

        //then
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input, count))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
