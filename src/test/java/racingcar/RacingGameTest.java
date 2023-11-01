package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RacingGameTest {
    private RacingGame racingGame;
    private UserInput userInput;
    private CarManagement carManagement;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
        carManagement = new CarManagement();
    }

    @Test
    void settingTest() {
        UserInput spyUserInput = Mockito.spy(userInput);
        CarManagement spyCarManagement = Mockito.spy(carManagement);
        racingGame = new RacingGame(spyUserInput, spyCarManagement);
        ByteArrayInputStream in = new ByteArrayInputStream("carA,carB,carC\n5".getBytes());
        System.setIn(in);

        racingGame.setting();
        verify(spyUserInput).getCarList();
        verify(spyCarManagement, times(3)).addCar(Mockito.anyString());
        verify(spyUserInput).getAttemptNumber();
    }

    @Test
    void playTest() throws NoSuchFieldException, IllegalAccessException {
        CarManagement spyCarManagement = Mockito.spy(carManagement);
        racingGame = new RacingGame(userInput, spyCarManagement);
        int attemptCountValue = 4;
        Field attemptCountField = RacingGame.class.getDeclaredField("attemptCount");
        attemptCountField.setAccessible(true);
        attemptCountField.setInt(racingGame, attemptCountValue);

        racingGame.play();
        verify(spyCarManagement, times(4)).playRound(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    void playRun() {
        CarManagement spyCarManagement = Mockito.spy(carManagement);
        racingGame = new RacingGame(userInput, spyCarManagement);
        RacingGame spyRacingGame = Mockito.spy(racingGame);
        ByteArrayInputStream in = new ByteArrayInputStream("carA,carB,carC\n5".getBytes());
        System.setIn(in);

        spyRacingGame.run();
        verify(spyRacingGame).setting();
        verify(spyRacingGame).play();
        verify(spyCarManagement).printWinner();
    }
}
