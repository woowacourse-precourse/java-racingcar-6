package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_전진여부_확인() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        //when
        car1.randomNum = 4;
        car1.moveForward();

        car2.randomNum = 2;
        car2.moveForward();

        //then
        assertThat(car1.getForwardCount() == 1);
        assertThat(car2.getForwardCount() == 0);
    }

    @Test
    public void 랜덤_번호_생성_확인() throws Exception {
        //given
        Car car = new Car("car");

        //when
        car.randomNum = -1;
        car.modifyRandomNum();

        //then
        assertThat(car.randomNum != -1);
    }

    @Test
    public void 자동차_출력_확인() throws Exception {
        //given
        Car car = new Car("car");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //when
        car.randomNum = 4;
        car.moveForward();
        car.displayMoveCount();

        //then
        assertThat(outContent.toString().trim()).isEqualTo("car : -");
    }

}
