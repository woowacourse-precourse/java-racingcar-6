package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomTest {
    @Test
    void 숫자_생성_성공(){
        //given
        int testCount = 1000;

        //when
        for (int i=0;i<testCount;i++){
            int randomNumber = Random.make(0, 9);

            //then
            assertThat(randomNumber >= 0 && randomNumber <= 9).isTrue();
        }
    }

    @Test
    void 숫자_4이상인_경우(){
        //given
        int number = 5;
        //when
        boolean b = Random.check(number);
        //then
        assertThat(b).isTrue();
    }

    @Test
    void 숫자_4미만인_경우(){
        //given
        int number = 3;
        //when
        boolean b = Random.check(number);
        //then
        assertThat(b).isFalse();
    }

    @Test
    void 숫자_랜덤_생성_후_검증_성공(){
        //given
        int r = Random.make(4, 9);

        //when
        boolean b = Random.check(r);

        //then
        assertThat(b).isTrue();
    }

}
