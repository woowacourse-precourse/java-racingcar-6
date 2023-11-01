package racingcar.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.dto.WinnersDTO;
import racingcar.view.WinnersView;

public class WinnersIntegrationTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }
    @Test
    void 우승자_여부_판단후_우승자_출력() {
        RacingCarGame racingCarGame = new RacingCarGame("pobi,jun", 5){
            @Override
            protected Cars initCars(String carNames){
                return new Cars(Arrays.asList(new Car(new CarName("pobi")), new Car(new CarName("jun")))){
                    @Override
                    public List<Car> findWinners(){
                        List<Car> carList = new ArrayList<>();
                        carList.add(new Car(new CarName("pobi")));
                        carList.add(new Car(new CarName("jun")));
                        return carList;
                    }
                };
            }
        };

        WinnersDTO winnersDTO = racingCarGame.finish();
        WinnersView winnersView = new WinnersView(winnersDTO);

        winnersView.view();

        assertEquals("최종 우승자 : pobi, jun", outputMessage.toString());
    }
}
