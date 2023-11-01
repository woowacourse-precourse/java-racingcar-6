package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.global.Constants.MAX_NUMBER_RANGE;
import static racingcar.global.Constants.MIN_NUMBER_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import jdk.jfr.Name;
import org.junit.jupiter.api.Test;

class DomainLogicTest {

    @Test
    @Name("랜덤 숫자가 0~9 사이의 숫자인지 확인")
    void pickNumberInRange() {
        // given
        int min = 0;
        int max = 9;
        // when
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
        // then
        assertTrue(min <= randomNumber && randomNumber <= max);
    }

    @Test
    @Name("제일 먼 거리를 가진 자동차의 위치를 가져오는 지 확인")
    void getMaxPosition() {
        // given
        CarGroup carGroup = CarGroup.from(
            Arrays.asList(
                Car.from("test1"),
                Car.from("test2")
            )
        );
        carGroup.getCars().get(0).move();
        // when
        int maxPosition = carGroup.getMaxPosition();
        // then
        assertEquals(1, maxPosition);
    }
}