package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CarTest {

    @DisplayName("전진하는 스코어 증가여부 테스트")
    @Test
    void getChanceToMoveTest() {
        Car car = Mockito.mock(Car.class);

        Mockito.when(car.pickRandomNumberToMove()).thenReturn(7);
        car.tryToGetMovementScore();

        Assertions.assertEquals(0,car.getMovementScore());
    }

    @DisplayName("랜덤숫자 범위 테스트")
    @RepeatedTest(20)
    void pickRandomNumberToMoveTest(){
        Car car = new Car("kwak",1);
        boolean result = true;

        if(car.pickRandomNumberToMove()<0 || car.pickRandomNumberToMove()>9){
            result = false;
        }

        Assertions.assertTrue(result);
    }

    @DisplayName("이름 확인 테스트")
    @Test
    void getNameTest(){
        //given
        Car car = new Car("kwak",5);
        //when
        String result = car.getName();
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals("kwak",result),
                () -> Assertions.assertNotEquals("Kwak",result)
        );
    }

    @DisplayName("사이클을 돌 때마다 남은 전진횟수 확인 테스트")
    @Test
    void getRemainMoveCountTest() {
        Car car = new Car("test",3);

        for(int i=0; i<3; i++) {
            car.tryToGetMovementScore();
        }

        Assertions.assertEquals(0,car.getRemainingOpportunity());
    }
}
