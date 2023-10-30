package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @DisplayName("정확한 갯수의 랜덤 숫자 리스트를 리턴하는지 확인합니다.")
    @Test
    void createRandomNumberListInRange() {
        RandomNumberGenerator randomNumberGenerator = spy(new RandomNumberGenerator());
        // 한 개의 랜덤 숫자를 리턴하는 메서드가 호출되면, 3,5,7,9,4,8순으로 값을 리턴하도록 설정.
        when(randomNumberGenerator.createOneRandomNumberInRange(1, 9))
                .thenReturn(3)
                .thenReturn(5)
                .thenReturn(7)
                .thenReturn(9)
                .thenReturn(4)
                .thenReturn(8);

        // 총 3개의 랜덤 숫자 리스트를 뽑아야 하므로, createRandomNumberListInRange의 결과는 3,5,7의 정수 리스트가 되어야 함.
        List<Integer> expected = List.of(3, 5, 7);
        assertThat(randomNumberGenerator.createRandomNumberListInRange(1, 9, 3))
                .isEqualTo(expected);
    }
}