package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarListTest {

    private CarList carList;

    @BeforeEach
    void init() {
        carList = CarList.from("skfk,zero");
    }

    @Test
    void 게임_횟수_입력만큼_실행되는지_확인() {
        carList.printGameProceed(2);
    }

    @Test
    void 게임_실행_결과를_확인하고_우승자와_결과가_동일한지_확인() {
        carList.printGameProceed(2);
        List<String> winners = carList.findWinner();
        System.out.println(winners);
    }
}