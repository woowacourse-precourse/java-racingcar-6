package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberUtilImp;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("입력된 이름이 5글자보다 많은 경우 예외 발생")
    void 예외_처리_테스트_1() {
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        assertThrows(IllegalArgumentException.class,
                () -> {
            new Car(movingStrategy, "yeonuel");
        });
    }

    @Test
    @DisplayName("공백이 입력된 경우 예외 발생")
    void 예외_처리_테스트_2() {
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Car(movingStrategy, "");
                });
    }


    @Test
    @DisplayName("위치 정보 조회")
    void getPosition_위치_조회_테스트(){
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        Car car = new Car(movingStrategy, "pobi");
        // when
        int result = car.getPosition();
        // then
        assertEquals(0, result);
    }


    @Test
    @DisplayName("이름 조회")
    void getName_이름_테스트() {
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        Car car = new Car(movingStrategy, "pobi");
        // when
        String result = car.getName();
        // then
        assertEquals("pobi", result);
    }


    @Test
    @DisplayName("위치 정보 기반으로 대소비교 - 위치 값이 더 큰 자동차가 큰 것으로 판단")
    void compareTo_대소비교_테스트() {
        // given
        MovingStrategy stopStrategy = new MovingStrategy((start, end) -> 3);
        MovingStrategy moveStrategy = new MovingStrategy((start, end) -> 4);
        Car car1 = new Car(stopStrategy, "pobi");
        Car car2 = new Car(moveStrategy, "crong");

        // when
        car1.goForward(); // car1 위치 0
        car2.goForward(); // car2 위치 1

        // then
        assertEquals(-1, car1.compareTo(car2));

    }

    @Test
    @DisplayName("MovingStrategy.isCarMove()가 false인 경우 goForward() 호출하면 위치 정보 업데이트 안됨")
    void goForward_멈춤_테스트() {
        // given
        MovingStrategy stopStrategy = new MovingStrategy((start, end) -> 3); // isCarMove() 항상 false 반환
        Car car = new Car(stopStrategy, "pobi");
        // when
        Boolean result = car.goForward();
        // then
        assertEquals(false, result);
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("MovingStrategy.isCarMove()가 true인 경우 goForward() 호출하면 위치 정보 업데이트됨")
    void goForward_전진_테스트() {
        // given
        MovingStrategy moveStrategy = new MovingStrategy((start, end) -> 4); // isCarMove() 항상 true 반환
        Car car = new Car(moveStrategy, "pobi");
        // when
        Boolean result = car.goForward();
        // then
        assertEquals(true, result);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("우승자의 위치 정보와 같은 경우 true 반환")
    void isWinner_우승자인_경우_테스트() {
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        Car car = new Car(movingStrategy, "pobi");
        // when
        Integer winnerPosition = 0;
        Boolean result = car.isWinner(winnerPosition);
        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("우승자의 위치 정보와 다른 경우 false 반환")
    void isWinner_우승자가_아닌_경우_테스트() {
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        Car car = new Car(movingStrategy, "pobi");
        // when
        Integer winnerPosition = 1;
        Boolean result = car.isWinner(winnerPosition);
        // then
        assertEquals(false, result);
    }


}