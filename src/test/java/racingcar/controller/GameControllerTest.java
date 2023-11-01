package racingcar.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import racingcar.IO.IOService;
import racingcar.dto.GameDto;
import racingcar.service.GameService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)

class GameControllerTest {

    @InjectMocks
    GameController gameController;

    private static MockedStatic<IOService> ioService;

    @BeforeAll
    public static void beforeAll() {
        ioService = mockStatic(IOService.class);
    }

    @AfterAll
    public static void afterAll() {
        ioService.close();
    }
    @Mock
    GameService gameService;

    @Test
    public void createGame() {
        GameDto result = new GameDto(1l, 1);

        when(IOService.inputCount()).thenReturn("1");
        when(IOService.inputCreate()).thenReturn("name");
        when(gameService.initGame(any(), any())).thenReturn(result);

        GameDto awd= gameController.createGame();

        verify(gameService).initGame(any(), any());
        assertEquals(awd,result);
    }

    @Test
    public void gameStart() {
        GameDto request = new GameDto(1l, 3);


        doNothing().when(gameService).processGame(any());
        doNothing().when(gameService).printResult(any());

        gameController.gameStart(request);

        verify(gameService,times(3)).processGame(any());
        verify(gameService,times(3)).printResult(any());

    }

    @Test
    public void printResult() {
        doNothing().when(gameService).resultPrint(any());

        gameController.printResult(new GameDto(1l,1));

        verify(gameService).resultPrint(any());

    }
}