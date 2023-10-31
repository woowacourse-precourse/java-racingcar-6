package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;

public class RacingGameTest extends NsTest {

    @DisplayName("우승자 목록을 생성하는 함수 테스트")
    @Test
    void getWinners() {

        //given
        RacingGame game = new RacingGame();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("dui"));
        carList.add(new Car("jeon"));

        carList.get(0).move(1); // "pobi" 1칸 전진
        carList.get(1).move(2); // "dui" 2칸 전진
        carList.get(2).move(2); // "jeon" 2칸 전진

        //when
        List<String> winners = game.getWinners(carList);

        //then
        assertEquals(List.of("dui", "jeon"), winners);
    }

    @Override
    protected void runMain() {

    }
}
