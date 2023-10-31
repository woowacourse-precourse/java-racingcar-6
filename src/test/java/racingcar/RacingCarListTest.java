package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

public class RacingCarListTest {
    private RacingCarList list;
    private RacingCarList listAsRacingCar;

    @BeforeEach
    void setUp() {
        this.list = new RacingCarList("aaa,bbb,ccc");
        this.listAsRacingCar = new RacingCarList();
    }

    @Test
    void 크기를구하는메서드_동작여부() {
        assertEquals(this.list.size(), 3);
        assertEquals(this.listAsRacingCar.size(), 3);
    }

    @Test
    void 리스트를_추가하는_메서드(){
        this.list.add(new RacingCar("444"));
        assertEquals(this.list.size(), 4);
    }

    @Test
    void 리스트를_비우는_메서드(){
        this.list.clear();
        assertEquals(this.list.size(), 0);
    }
}
