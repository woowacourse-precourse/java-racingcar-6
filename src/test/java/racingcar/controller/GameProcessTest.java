package racingcar.controller;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

public class GameProcessTest {
    private GameProcess process;
    private RacingCarList carList;
    @BeforeEach
    void setUp(){
        process = new GameProcess();
        carList = new RacingCarList("aaa,bbb,ccc");
    }

    @Test
    void 랜덤_값_입력_테스트(){
        process.processGame(carList);
        for(int index = 0; index < carList.size(); index++){
            RacingCar temp = carList.get(index);
            assertThat(temp.getDistance())
                    .isPositive();
        }
    }
}
