package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.List;


public class RaceGameTest {
    private void provideInput(String data) {
        InputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void MakeCarNameList_입력받은_값을_car객체로_변환_후_List에_담기() {
        List<Car> carNameList = Application.makeCarNameList("Car1,Car2,Car3");
        assertEquals(3, carNameList.size());
        assertEquals("Car1", carNameList.get(0).name);
        assertEquals("Car2", carNameList.get(1).name);
        assertEquals("Car3", carNameList.get(2).name);
    }

    @Test
    void CheckInputValue_빈값이_입력되면_예외처리() {
        List<String> invalidInput = List.of(",,");
        assertThatThrownBy(() -> Application.checkInputValue(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void GetTryingNumber_시도할_횟수_입력받기() {
        provideInput("5");
        int tryingCount = Application.getTryingNumber();
        assertEquals(5, tryingCount);
    }

    @Test
    void checkTryingNumber_숫자가_아닐_경우_예외처리() {
        assertThatThrownBy(() -> Application.checkTryingNumber("안녕"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void IsForward_숫자_4이상만_전진() {
        assertTrue(Application.isForward(5));
        assertFalse(Application.isForward(3));
    }

    @Test
    void FindWinner_우승자_찾기() {
        List<Car> carNameList = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));
        carNameList.get(0).forwardDash = "----";
        carNameList.get(1).forwardDash = "-------";
        carNameList.get(2).forwardDash = "----";

        assertEquals("Car2", Application.findWinner(carNameList));
    }
}
