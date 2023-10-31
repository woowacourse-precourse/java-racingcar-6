package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {

    private Counter counter;
    public static final int TEST_REPEAT = 5;

    @BeforeEach
    public void init(){
        counter=new Counter(TEST_REPEAT);
    }

    @Test
    public void 게임이_끝나면_True를_반환() {

        for (int i = 0; i < TEST_REPEAT; i++) {
            counter.reduceCount();
        }

        assertThat(counter.isEnd()).isTrue();
    }

    @Test
    public void 게임이_끝지않았다면_False를_반환() {

        for (int i = 0; i < TEST_REPEAT-1; i++) {
            counter.reduceCount();
        }

        assertThat(counter.isEnd()).isFalse();
    }

}
