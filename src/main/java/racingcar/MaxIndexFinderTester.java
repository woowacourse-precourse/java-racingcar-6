package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MaxIndexFinderTester {
    @Test
    @DisplayName("올바른 최대값을 가진 인덱스를 출력하는지 확인")
    void MaxIndexFinder_테스트(){
        MaxIndexFinder maxIndexFinder = new MaxIndexFinder();
        List<Integer> count = Arrays.asList(10,10,20,30,20);
        int max_index = maxIndexFinder.findMaxIndex(count);
        assertThat(max_index).isEqualTo(3);
    }
}
