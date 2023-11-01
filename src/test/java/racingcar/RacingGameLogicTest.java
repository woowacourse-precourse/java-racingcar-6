package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RacingGameLogicTest {

    @Test
    @DisplayName("우승자가 한명일 때 테스트")
    void testGetWinner() {
        //given
        RacingCar car1 = mock(RacingCar.class);
        RacingCar car2 = mock(RacingCar.class);
        when(car1.getName()).thenReturn("페라리");
        when(car2.getName()).thenReturn("아우디");
        when(car1.getMovement()).thenReturn("----");
        when(car2.getMovement()).thenReturn("--");
        //when
        List<RacingCar> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);

        RacingGameLogic racingGameLogic = new RacingGameLogic();
        List<RacingCar> winners = racingGameLogic.getWinners(list);

        //then
        assertEquals("----", winners.get(0).getMovement());
        assertEquals("페라리", winners.get(0).getName());
    }

    @Test
    @DisplayName("우승자가 여러명일 떄 테스트")
    void testGetMultipleWinners() {
        //given
        RacingCar car1 = mock(RacingCar.class);
        RacingCar car2 = mock(RacingCar.class);
        when(car1.getName()).thenReturn("페라리");
        when(car2.getName()).thenReturn("아우디");
        when(car1.getMovement()).thenReturn("------");
        when(car2.getMovement()).thenReturn("------");

        //when
        List<RacingCar> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);

        RacingGameLogic racingGameLogic = new RacingGameLogic();
        List<RacingCar> winners = racingGameLogic.getWinners(list);

        //then
        assertEquals(2, winners.size());
        assertEquals("페라리", winners.get(0).getName());
        assertEquals("아우디", winners.get(1).getName());
    }
}