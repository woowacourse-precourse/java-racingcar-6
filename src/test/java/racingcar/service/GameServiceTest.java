package racingcar.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import racingcar.entity.Car;
import racingcar.entity.Game;
import racingcar.repository.CarRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import racingcar.IO.IOService;
import racingcar.dto.GameDto;
import racingcar.entity.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @InjectMocks
    GameService gameService;
    @Mock
    GameRepository gameRepository;

    @Mock
    CarService carService;



    @Test
    void initGameTest() {
        when(gameRepository.save(any())).thenReturn(1l);
        when(carService.carCreate(any())).thenReturn(new Car("car"));

        gameService.initGame("a,b,c", 1);
        verify(carService, times("a,b,c".split(",").length)).carCreate(any());
    }



}