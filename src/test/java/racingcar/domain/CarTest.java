package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;
    private static final String name = "jun";
    @BeforeEach
    void setUp(){
        car = new Car(name);
    }
    private static final int DEPART_NUM = 4;
    private static final int CANNOT_GO = 3;
    private static final int MOVE = 1;
    private static final int STOP = 0;

    @Test
    void 수가_랜덤_중_4_이상_일_때_직진(){
        car.goForward(DEPART_NUM);
        assertThat(car.getForward()).isEqualTo(MOVE);
    }

    @Test
    void 수가_랜덤_중_4가_안_될_때(){
        car.goForward(CANNOT_GO);
        assertThat(car.getForward()).isEqualTo(STOP);
    }

    @Test
    void 이름_받아_오기(){
        assertThat(car.getName()).isEqualTo("jun");
    }
    @Test
    void 전진_횟수_받아_오기(){
        assertThat(car.getForward()).isEqualTo(0);
    }

}