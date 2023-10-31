package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RacingGameTest {
    private RacingGame racingGame;
    private UserInput userInput;
    private CarManagement carManagement;
    @BeforeEach
    void setUp(){
        userInput=new UserInput();
        carManagement=new CarManagement();

    }
    @Test
    void settingTest(){
        UserInput spyUserInput = Mockito.spy(userInput);
        CarManagement spyCarManagement = Mockito.spy(carManagement);
        racingGame=new RacingGame(spyUserInput,spyCarManagement);
        ByteArrayInputStream in = new ByteArrayInputStream("carA,carB,carC\n5".getBytes());
        System.setIn(in);
        racingGame.setting();
        verify(spyUserInput).getCarList();
        verify(spyCarManagement, times(3)).addCar(Mockito.anyString());
        verify(spyUserInput).getAttemptNumber();
    }
    @Test
    void playTest(){

    }
    @Test
    void playRun(){

    }

}
