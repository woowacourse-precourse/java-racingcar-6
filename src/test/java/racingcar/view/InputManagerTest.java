package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class InputManagerTest {

    InputManager inputManager;

    @BeforeEach
    public void beforeEach() {
        inputManager = new InputManager();
    }

    @Test
    void inputTryCountTest_유효성체크_성공() {
        //given
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        Integer result = inputManager.inputTryCount();
        //then
        Integer expected = 5;
        assertEquals(expected, result);
    }

    @Test
    void inputTryCountTest_유효성체크_실패_숫자가_아닌_경우() {
        //given
        String input = "A";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        assertThatThrownBy(() -> inputManager.inputTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID tryCount : non-numeric characters");
    }

    @Test
    void inputTryCountTest_유효성체크_실패_1보다_작은_경우() {
        //given
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        assertThatThrownBy(() -> inputManager.inputTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID tryCount : number less than 1");
    }

    @Test
    void inputCarNamesTest_유효성체크_성공() {
        //given
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        List<Car> result = inputManager.inputCarNames();
        //then
        assertThat( result.get(0).getCarName()).isEqualTo("pobi");
        assertThat( result.get(1).getCarName()).isEqualTo("woni");
        assertThat( result.get(2).getCarName()).isEqualTo("jun");

    }

    @Test
    void inputCarNamesTest_유효성체크_실패_이름이_없는_경우() {
        //given
        String input = "pobi,,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        assertThatThrownBy(() -> inputManager.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID carName : carName is empty");

    }

    @Test
    void inputCarNamesTest_유효성체크_실패_이름이_blank로만_이루어진_경우() {
        //given
        String input = "pobi, ,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        assertThatThrownBy(() -> inputManager.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID carName : carName is empty");

    }

    @Test
    void inputCarNamesTest_유효성체크_실패_5자리_이상() {
        //given
        String input = "pobi,abcdef,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        assertThatThrownBy(() -> inputManager.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID carName : carName length is over then 5");

    }

    @Test
    void inputCarNamesTest_유효성체크_이름이_이미_존재하는_경우() {
        //given
        String input = "pobi,pobi,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        assertThatThrownBy(() -> inputManager.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID carName : carName already exists.");

    }

    @Test
    void convertToCarMapTest() {
        //given
        String[] input = {"pobi", "woni", "jun"};
        //when
        assertDoesNotThrow(() -> {
            inputManager.convertToCarList(input);
        });
        List<Car> result = inputManager.convertToCarList(input);
        //then
        assertEquals(3, result.size());
        assertEquals(result.get(0).getCarName(),"pobi");
        assertEquals(result.get(1).getCarName(),"woni");
        assertEquals(result.get(2).getCarName(),"jun");

    }
}