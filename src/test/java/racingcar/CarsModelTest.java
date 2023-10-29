package racingcar;

        import static org.assertj.core.api.Assertions.assertThat;
        import static org.mockito.Mockito.mock;
        import static org.mockito.Mockito.mockStatic;
        import static org.mockito.Mockito.when;

        import camp.nextstep.edu.missionutils.Randoms;
        import java.util.ArrayList;
        import java.util.List;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.MockedStatic;
        import racingcar.model.Car;
        import racingcar.model.Cars;

public class CarsModelTest {
    List<Car> carList;


    @BeforeEach
    void init() {
        carList = new ArrayList<>();
    }

    @Test
    void 자동차_이름과_결과를_String_리스트로_리턴() {
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        Car car3 = mock(Car.class);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        when(car1.getNameWithPosition()).thenReturn("car1 : -----");
        when(car2.getNameWithPosition()).thenReturn("car2 : ---");
        when(car3.getNameWithPosition()).thenReturn("car3 : ----");

        assertThat(cars.getRoundResult()).containsExactly("car1 : -----", "car2 : ---", "car3 : ----");
    }

    @Test
    void 포지션이_제일_큰_자동차_이름들을_리턴() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        MockedStatic<Randoms> randoms = mockStatic(Randoms.class);
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(4);
        // car1 & car2 position : 2
        car1.move();
        car1.move();
        car2.move();
        car2.move();

        when(Randoms.pickNumberInRange(0, 9)).thenReturn(0);
        // car3 position : 0
        car3.move();
        car3.move();

        assertThat(cars.getWinner()).containsExactly("car1", "car2");

        randoms.close();
    }
}
