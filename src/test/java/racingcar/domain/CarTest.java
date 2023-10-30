package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;

public class CarTest{

    MockedStatic<Randoms> randoms;

    @BeforeEach
    void init(){
        randoms = mockStatic(Randoms.class);
    }

    @AfterEach
    void afterAll(){
        randoms.close();
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
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(4);
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
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(2);
        car.drive();

        //then
        assertThat(car.getForwardCount()).isEqualTo(0);

    }

    @Test
    @DisplayName("자동차 상태를 형식에 맞춰 출력한다.")
    void 자동차_상태_출력(){
        //given
        Car car = new Car("Pobi");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(7);
        car.drive();
        car.printCarState();

        //then
        assertThat(out.toString()).isEqualTo("Pobi : -------\r\n");

    }

}
