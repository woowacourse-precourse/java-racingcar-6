package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Car;

public class CarTest {

    @Test
    public void 자동차객체하나_생성_문자이름으로() {
        // given
        String name = "pobi";

        // when
        Car car = Car.create(name);

        // then
        assertEquals(name, car.getName());
    }

    @Test
    public void 자동차객체리스트_생성_문자이름리스트로() {
        // given
        List<String> nameList = Arrays.asList("pobi", "woni");

        // when
        List<Car> carList = Car.createList(nameList);

        // then
        assertEquals(2, carList.size());
        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
    }

    @Test
    public void 자동차의_최대포지션계산() {
        // given
        Car car = Car.create("pobi");
        car.addPositionByRandomNum(1);
        car.addPositionByRandomNum(4);

        // when
        int maxPosition = car.calcMaxPosition();

        // then
        assertEquals(1, maxPosition);
    }

    @Test
    public void 특정턴에서_위치조회() {
        // given
        Car car = Car.create("pobi");
        car.addPositionByRandomNum(1);
        car.addPositionByRandomNum(4);

        // when
        int positionAt1 = car.findPositionAt(0);
        int positionAt2 = car.findPositionAt(1);

        // then
        assertEquals(0, positionAt1);
        assertEquals(1, positionAt2);
    }

    @Test
    public void 랜덤숫자_조건에맞으면_한칸이동() {
        // given
        Car car = Car.create("pobi");

        // when
        car.addPositionByRandomNum(4);

        // then
        assertThat(car.findPositionAt(0)).isEqualTo(1);
    }

    @Test
    public void 랜덤숫자_조건에맞지않으면_한칸이동안함() {
        // given
        Car car = Car.create("pobi");

        // when
        car.addPositionByRandomNum(1);

        // then
        assertThat(car.findPositionAt(0)).isEqualTo(0);
    }

    @Test
    public void 현재위치가_파라미터값보다_크면_참() {
        // given
        Car car = Car.create("pobi");
        car.addPositionByRandomNum(4);

        // when
        boolean bool = car.isCurrPositionSameOrOver(0);

        // then
        assertTrue(bool);
    }

    @Test
    public void 현재위치가_파라미터값과_같으면_참() {
        // given
        Car car = Car.create("pobi");
        car.addPositionByRandomNum(1);

        // when
        boolean bool = car.isCurrPositionSameOrOver(0);

        // then
        assertTrue(bool);
    }

    @Test
    public void 현재위치가_파라미터값보다_작으면_거짓() {
        // given
        Car car = Car.create("pobi");
        car.addPositionByRandomNum(4);

        // when
        boolean bool = car.isCurrPositionSameOrOver(2);

        // then
        assertFalse(bool);
    }
}