package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.NameLocationPair;
import racingcar.dto.PlayResultDTO;
import racingcar.dto.ResultEachTry;

class RacingCarGameTest {
    @Test
    void 시도횟수만큼_전진멈춤_계산후_결과반환() {
        final int GO_ALWAYS = 5;
        final int STAY_ALWAYS = 3;

        final int TRY_NUM = 3;

        String carNames = "go,stay";

        PlayResultDTO expected = new PlayResultDTO(
                Arrays.asList(
                        new ResultEachTry(1, Arrays.asList(
                                new NameLocationPair("go", 1),
                                new NameLocationPair("stay", 0))
                        ),
                        new ResultEachTry(2, Arrays.asList(
                                new NameLocationPair("go", 2),
                                new NameLocationPair("stay", 0))
                        ),
                        new ResultEachTry(3, Arrays.asList(
                                new NameLocationPair("go", 3),
                                new NameLocationPair("stay", 0))
                        )
                )
        );

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

        assertEquals(expected, playResultDTO);
    };
}