package mytest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.Car;

public class CarDomainTest {
    @DisplayName("Car 클래스의 기본생성자를 통해 인스턴스 객체 생성 시 새로운 ArrayList가 생성되는지 테스트")
    @Test
    void constructorTest1(){
        //given
        Car car=new Car();
        List<String> carNameList = car.getCarNameList();
        //then
        assertThat(carNameList).isInstanceOf(ArrayList.class);
    }
    @DisplayName("Car 클래스의 인스턴스 객체를 생성 시 생성자에 carName 주입 할 때 carName,position이 생성되는지 테스트 ")
    @Test
    void constructorTest2(){
        Car car=new Car("aaa");
        assertEquals(car.getCarName(),"aaa");
        assertEquals(car.getPosition(),0);
    }
    @DisplayName("Car 클래스 인스턴스 생성시 생성자에 carName 주입 할 때 이름이 5글자를 초과하면 에러 발생 확인.")
    @Test
    void validateCarNameLength(){
        assertThrows(IllegalArgumentException.class,()->{
            Car car=new Car("aaaaaa");
        });
    }
    @DisplayName("forwardOrStop 메서드 호출 시 내부에서 0~9사이의 랜덤 값이 정상적으로 추출되는지 확인.")
    @RepeatedTest(10)
    void validateRandomNumber(){
        final int START_INCLUSIVE=0;
        final int END_INCLUSIVE=9;
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        assertTrue(randomNumber>=START_INCLUSIVE);
        assertTrue(randomNumber<=END_INCLUSIVE);
    }
    @DisplayName("랜덤한 숫자가 4이상이면 앞으로 전진,4미만이면 정지하는 메소드 테스트.")
    @Test
    void moveForward() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // MoveForward 메서드 가져오기
        Class<Car> myCar = Car.class;
        Method moveForwardMethod = myCar.getDeclaredMethod("moveForward", int.class);
        moveForwardMethod.setAccessible(true); // private 메서드에 접근 권한 설정

        // Car 인스턴스 생성
        Car car = new Car();

        // moveForward 메서드 호출
        int randomNumber = 5; // 임의의 숫자
        moveForwardMethod.invoke(car, randomNumber);

        // 테스트 검증 로직 추가
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
