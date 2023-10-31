package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ForwardDistanceTest {

    private ForwardDistance forwardDistance;

    @BeforeEach
    void setUp() {
        forwardDistance = new ForwardDistance();
    }

    @Test
    void 생성자로_생성시_distance가_0() {
        assertThat(forwardDistance.getValue()).isEqualTo(0);
    }
    @Test
    void increase메서드로_1이_증가() {
        //when
        forwardDistance.increase();

        //then
        assertThat(forwardDistance.getValue()).isEqualTo(1);
    }

    @Test
    void toString메서드시_바형태로_출력() {
        //given
        forwardDistance.increase();
        forwardDistance.increase();

        //when&then
        assertThat(forwardDistance.toString()).isEqualTo("--");
    }
}