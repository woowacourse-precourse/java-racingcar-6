package racingcar;

import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Test
    void 숫자생성_테스트(){
        NumberGenerator ng = new NumberGenerator();
        int result = ng.createNumber();
        System.out.println("생성된 숫자 :" + result);
    }

}