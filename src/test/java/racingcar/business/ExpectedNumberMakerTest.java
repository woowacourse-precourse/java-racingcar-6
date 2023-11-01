package racingcar.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ExpectedNumberMakerTest {

    ExpectedNumberMaker expectedNumberMaker;

    @BeforeEach
    public void create() {
        expectedNumberMaker = new ExpectedNumberMaker();
    }

    @Test
    @DisplayName("전달한 숫자와 반환한 숫자가 일치한다.")
    void setExpectedNumbers() {
        // given
        List<Integer> expectedNumbers = Arrays.asList(1);

        // when
        expectedNumberMaker.setExpectedNumbers(expectedNumbers);

        // then
        Integer randomNumber = expectedNumberMaker.getRandomNumber();
        assertThat(randomNumber).isEqualTo(1);
    }

    @Test
    @DisplayName("전달한 숫자 리스트와 반환한 숫자 리스트가 일치한다.")
    void getRandomNumber() {
        // given
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3);
        expectedNumberMaker.setExpectedNumbers(expectedNumbers);

        List<Integer> receiveNumbers = new ArrayList<>();

        // when
        for (int i = 0; i < expectedNumbers.size(); i++) {
            Integer randomNumber = expectedNumberMaker.getRandomNumber();
            System.out.println("randomNumber = " + randomNumber);
            receiveNumbers.add(randomNumber);
        }

        // then
        assertThat(receiveNumbers).isEqualTo(expectedNumbers);
    }

}