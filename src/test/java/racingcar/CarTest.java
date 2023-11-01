package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    @Test
    @DisplayName("랜덤 숫자 생성 확인")
    void 랜덤_숫자_생성() {
        Car car = new Car();
        int randomNumber = car.createRandomNumber();
        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @Test
    @DisplayName("랜덤 숫자가 4 미만일 때 전진하지 않는지 확인")
    void 랜덤_숫자_4미만_정지() {
        Car car = new Car();
        car.status = "--";
        int randomNumber = 3;
        car.judgeRandomNumber(randomNumber);
        assertThat(car.status).isEqualTo("--");
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상일 때 전진하는지 확인")
    void 랜덤_숫자_4이상_이동() {
        Car car = new Car();
        car.status = "--";
        int randomNumber = 4;
        car.judgeRandomNumber(randomNumber);
        assertThat(car.status).isEqualTo("---");
    }

    @Test
    @DisplayName("자동차 전진할 때 이름 출력")
    void 전진_이름_출력() {
        Car car = new Car();
        car.carName = "siwon";
        car.status = "----";
        assertThat(car.printCarStatus()).isEqualTo("siwon : ----");
    }

}
