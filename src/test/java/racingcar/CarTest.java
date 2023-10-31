package racingcar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void 자동차_생성() {
        car = new Car("자동차1");
    }

    @Test
    void 프로세스_1증가_테스트() {
        car.increaseProcess();
        assertThat(car.getProcess()).isEqualTo(1);
    }

    @Test
    void 프로세스_10증가_테스트() {
        for(int i=0; i<10; i++){
            car.increaseProcess();
        }
        assertThat(car.getProcess()).isEqualTo(10);
    }

    @Test
    void 자동차_정보_테스트() {
        car.increaseProcess();
        car.increaseProcess();
        assertThat(car.info()).isEqualTo("자동차1 : --\n");
    }

    @Test
    void 프로세스_비교_테스트(){
        Car car2 = new Car("자동차2");
        car2.increaseProcess();
        assertThat(car.compareTo(car2)).isGreaterThan(0);
        assertThat(car2.compareTo(car)).isLessThan(0);
    }

    @Test
    void 우승자_검증_테스트() {
        assertThat(car.isWinner(2)).isFalse();
        car.increaseProcess();
        car.increaseProcess();
        assertThat(car.isWinner(2)).isTrue();
    }
}
