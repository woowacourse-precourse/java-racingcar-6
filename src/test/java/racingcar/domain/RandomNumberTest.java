package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.service.RandomNumberService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomNumberTest {
    @Test
    void 랜덤수생성(){
        RandomNumber randomNumber = new RandomNumber();
        int num = randomNumber.getNumber();
        Boolean result = false;
        if(num>=0 && num <=9) result = true;

        assertThat(result).isEqualTo(true);
    }

    @Test
    void 전진_4이상(){
        RandomNumberService randomNumberService= new RandomNumberService(1);
        int testNum = 5;
        Boolean result = randomNumberService.move(testNum);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void 정지_4미만(){
        RandomNumberService randomNumberService= new RandomNumberService(1);
        int testNum = 3;
        Boolean result = randomNumberService.move(testNum);

        assertThat(result).isEqualTo(false);
    }
}