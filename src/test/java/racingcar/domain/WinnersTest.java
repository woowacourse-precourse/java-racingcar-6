package racingcar.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WinnersTest {
    private List<Car> cars;
    private Winners winners;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        Car car1 = mock(Car.class);
        when(car1.getName()).thenReturn("Car1");
        when(car1.getPosition()).thenReturn(3);

        Car car2 = mock(Car.class);
        when(car2.getName()).thenReturn("Car2");
        when(car2.getPosition()).thenReturn(4);

        Car car3 = mock(Car.class);
        when(car3.getName()).thenReturn("Car3");
        when(car3.getPosition()).thenReturn(2);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        winners = new Winners(cars);
    }
    @Test
    void getMaxPosition_테스트() {
        assertEquals(4, winners.getMaxPosition(cars));
    }
    @Test
    void getWinners_테스트() {
        List<Car> expectedWinners = new ArrayList<>();
        expectedWinners.add(cars.get(1));

        assertEquals(expectedWinners, winners.getWinners(cars));
    }
    @Test
    void getWinnersName_테스트() {
        List<String> expectedWinnersNames = List.of("Car2");
        List<String> actualWinnersNames = winners.getWinnersName();

        assertEquals(expectedWinnersNames, actualWinnersNames);
    }
}