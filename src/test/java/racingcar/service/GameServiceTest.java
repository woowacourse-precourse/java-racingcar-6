package racingcar.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class GameServiceTest {
    static GameService gameService;
    static MockedStatic<Randoms> mockedRandoms;

    @BeforeAll
    public static void init() {
        gameService = GameService.getInstance();
        mockedRandoms = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterAll() {
        mockedRandoms.close();
    }

    @Test
    void 주행_결과_통과() {
        String[] names = {"car1", "car2"};
        List<Car> cars = createCars(names);
        int tries = 2;

        given(Randoms.pickNumberInRange(0, 9)).willReturn(4, 3, 4, 3);
        Assertions.assertThat(gameService.doTurns(cars, tries)).contains("car1 : -", "car2 : ", "car1 : --", "car2 : ");
    }

    @Test
    void 주행_결과_통과2() {
        String[] names = {"car1", "car2"};
        List<Car> cars = createCars(names);
        int tries = 2;

        given(Randoms.pickNumberInRange(0, 9)).willReturn(9, 9, 9, 9);
        Assertions.assertThat(gameService.doTurns(cars, tries)).contains("car1 : -", "car2 : -", "car1 : --", "car2 : --");
    }

    @Test
    void 시도_zero_주행_결과_통과() {
        String[] names = {"car1", "car2"};
        List<Car> cars = createCars(names);
        int tries = 0;

        Assertions.assertThat(gameService.doTurns(cars, tries)).isEqualTo("");
    }

    @Test
    void 우승자_Car1_테스트() {
        String[] names = {"car1", "car2"};
        List<Car> cars = createCars(names);
        cars.set(0, Mockito.spy(cars.get(0)));
        cars.set(1, Mockito.spy(cars.get(1)));

        doReturn(true).when(cars.get(0)).isWinner(anyInt());
        doReturn(false).when(cars.get(1)).isWinner(anyInt());

        Assertions.assertThat(gameService.getWinnersList(cars)).isEqualTo("car1");
    }

    @Test
    void 공동_우승자_테스트() {
        String[] names = {"car1", "car2"};
        List<Car> cars = createCars(names);
        cars.set(0, Mockito.spy(cars.get(0)));
        cars.set(1, Mockito.spy(cars.get(1)));

        doReturn(true).when(cars.get(0)).isWinner(anyInt());
        doReturn(true).when(cars.get(1)).isWinner(anyInt());

        Assertions.assertThat(gameService.getWinnersList(cars)).isEqualTo("car1, car2");
    }

    private List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (int idx = 0; idx < names.length; idx++) {
            cars.add(new Car(names[idx]));
        }

        return cars;
    }
}
