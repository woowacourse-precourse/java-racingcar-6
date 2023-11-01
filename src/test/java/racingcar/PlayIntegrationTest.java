package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.dto.PlayResultDTO;
import racingcar.view.PlayResultView;

public class PlayIntegrationTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }
    @Test
    void 자동차_경주를_실행하면_각차수별_결과를_출력() {
        final int GO_ALWAYS = 5;
        final int STAY_ALWAYS = 3;

        final int TRY_NUM = 3;

        String carNames = "go,stay";

        Car goAll = new Car(new CarName("go")){
            @Override
            protected int getRandomNumber(){
                return GO_ALWAYS;
            }
        };
        Car stayAll = new Car(new CarName("stay")){
            @Override
            protected int getRandomNumber(){
                return STAY_ALWAYS;
            }
        };

        List<Car> goAllAndStayAll = new ArrayList<>();

        goAllAndStayAll.add(goAll);
        goAllAndStayAll.add(stayAll);

        RacingCarGame racingCarGame = new RacingCarGame(carNames, TRY_NUM){
            @Override
            protected Cars initCars(String carNames){
                return new Cars(goAllAndStayAll);
            }
        };

        PlayResultDTO playResultDTO = racingCarGame.play();
        PlayResultView playResultView = new PlayResultView(playResultDTO);
        playResultView.view();

        assertEquals(
                "실행 결과\n"
                        + "go : -\n"
                        + "stay : \n"
                        + "\n"
                        + "go : --\n"
                        + "stay : \n"
                        + "\n"
                        + "go : ---\n"
                        + "stay : \n"
                        + "\n",
                outputMessage.toString()
        );
    }
}
