package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameProgressionTest {

    @Test
    void 점수_리스트_초기화() {
        // given(준비): playerList = Arrays.asList("pobi", "jun")
        Player player = new Player();
        List<String> playerList = Arrays.asList("pobi", "jun");
        // when(실행): scoreList를 호출
        List<Integer> scoreList = player.setScore(playerList);
        // then(검증): scoreList가 정확히 0,0으로 되어있는지 확인
        assertEquals(Arrays.asList(0, 0), scoreList);
    }

}