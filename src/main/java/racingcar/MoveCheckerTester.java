package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.Arrays;
import java.util.List;

public class MoveCheckerTester {
    public boolean isInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }
    @Test
    @DisplayName("count의 원소가 0부터 1사이에 존재하는지 확인")
    void MoveChecker_테스트(){
        MoveChecker moveChecker = new MoveChecker();
        List<String> members = Arrays.asList("poni", "woni", "jun");
        List<Integer> count = Arrays.asList(0,0,0);
        count = moveChecker.checkMoveOrStop(members, count);
        List<Integer> finalCount = count;
        assertAll(
                () -> assertTrue(isInRange(finalCount.get(0), 0, 1)),
                () -> assertTrue(isInRange(finalCount.get(1), 0, 1)),
                () -> assertTrue(isInRange(finalCount.get(2), 0, 1))
        );
    }

}
