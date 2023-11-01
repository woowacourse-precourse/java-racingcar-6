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
}
