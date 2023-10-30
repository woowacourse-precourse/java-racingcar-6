package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyTest {

    @Test
    void 한_칸_움직이면_한_줄_추가된다() {
        Racer racer = new Racer("이름");
        assertThat(racer.getScore()).isEqualTo("");
        racer.move();
        assertThat(racer.getScore()).isEqualTo("-");
    }

}