package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.dto.CarsDTO;
import racingcar.domain.gameInfo.InputManager;
import racingcar.service.GameService;

public class GameServiceTest {

    @Mock
    private InputManager inputManager;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("올바른 반환값으로 정상적으로 레이스가 시작되는지 검증")
    public void 레이스_시작_테스트() throws Exception {
        //given
        List<Car> carList = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"));
        when(inputManager.getParsedCarList()).thenReturn(carList);
        when(inputManager.getGameProcessCount()).thenReturn(5);

        //when
        int round = GameService.racingStart(inputManager);

        //then
        assertEquals(5, round);
    }

    @Test
    @DisplayName("라운드가 진행되는지 검증")
    public void 라운드_진행_테스트() throws Exception {
        //given
        GameService gameService = new GameService();
        Cars cars = mock(Cars.class);

        //when
        gameService.setCars(cars);
        gameService.progressRound();

        //then
        // oneRoundProgress가 정확히 한 번 호출되는 지 검증
        verify(cars, times(1)).oneRoundProgress(any());
    }

    @Test
    @DisplayName("우승자가 정상적으로 선택되는지 검증")
    public void 우승자_선택_테스트() throws Exception {
        //given
        GameService gameService = new GameService();
        Cars cars = mock(Cars.class);
        gameService.setCars(cars);
        List<Car> winnerList = Arrays.asList(new Car("pobi"), new Car("woni"));
        when(cars.getWinners()).thenReturn(winnerList);

        //when
        String winners = gameService.chooseWinner();

        //then
        assertEquals("pobi, woni", winners);
    }

    @Test
    @DisplayName("DTO 변환이 정확한지 검증")
    public void DTO_변환_테스트() throws Exception {
        //given
        GameService gameService = new GameService();
        List<Car> carList = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"));
        Cars cars = new Cars(carList);
        gameService.setCars(cars);

        //when
        CarsDTO carsDTO = gameService.transferCarsDTO();

        //then
        Assertions.assertEquals(carsDTO.getCarList(), carList);

    }


}
