package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarListTest {

    private CarList carList;

    @BeforeEach
    void init() {
        carList = CarList.from("skfk,zero");
    }

    @Test
    void 게임_횟수_입력값만큼_실행되는지_확인() {
        carList.printGameProceed(2);
    }
}