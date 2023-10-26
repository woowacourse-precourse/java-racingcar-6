package racingcar.util;

import org.junit.jupiter.api.Test;

class RandomNumberGenratorTest {
    private final NumberGenrator numberGenrator = new RandomNumberGenrator();
    @Test
    void 랜덤_넘버_생성_단순_확인_테스트(){
        //given
        final int number = numberGenrator.generate();

        //when,then
        System.out.println(number);
    }
}