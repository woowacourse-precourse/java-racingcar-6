package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CarTest{

    @Mock
    NumberGenerator numberGenerator;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("자동차 이름이 5보다 길면 예외를 던진다.")
    void 자동차_이름_길이_예외_처리(){
        assertThatThrownBy(() -> new Car("looooong")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 전진 시 전진 횟수 증가시킨다.")
    void 자동차_전진(){
        //given
        Car car = new Car("Pobi");

        //when
        Mockito.when(numberGenerator.createRandomNumber()).thenReturn(4);
        car.drive();

        //then
        assertThat(car.getForwardCount()).isEqualTo(1);

    }

    @Test
    @DisplayName("자동차 멈춤 시 전진 횟수 증가시키지 않는다.")
    void 자동차_멈춤(){
        //given
        Car car = new Car("Pobi");

        //when
        Mockito.when(numberGenerator.createRandomNumber()).thenReturn(2);
        car.drive();

        //then
        assertThat(car.getForwardCount()).isEqualTo(0);

    }

}
