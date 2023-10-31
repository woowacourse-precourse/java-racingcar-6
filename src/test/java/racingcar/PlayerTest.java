package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {
    private Player player;
    @BeforeEach
    void setUp() {
        player = new Player();
    }
    @Test
    void 플레이어_설정_확인() {
        //given(준비): input data = 'pobi,woni,jun'입력했을때
        String inputData = "pobi,woni,jun";
        //when(실행):  setThePlayer() 실행하면
        List<String> playerList = player.setThePlayer(inputData);
        //then(검증):  playerList가 'pobi','woni','jun'을 정확히 일치하게 포함한다.
        assertThat(playerList).isEqualTo(Arrays.asList("pobi", "woni", "jun"));

    }
    @Test
    void 리스트_길이_일치_여부() {
        //given(준비):input data = 'pobi,woni,jun'입력했을때
        String inputData = "pobi,woni,jun";
        List<String> playerList = player.setThePlayer(inputData);
        //when(실행): setScore() 실행하면
        List<Integer> scoreList = player.setScore(playerList);
        //then(검증): platerList와 scroreList의 길이가 일치해야한다.
        assertThat(scoreList).hasSize(playerList.size());
    }

    @Test
    void 입력_예외_발생_확인(){
        //given(준비): input data = 'pobi,woni,hyejii'입력했을 때
        String inputData = "pobi,woni,hyejii";
        //when(실행): setThePlayer() 실행하면
        //then(검증): IllegalArgumentException 발생해야한다.
        assertThrows(IllegalArgumentException.class, () -> player.setThePlayer(inputData));

    }
}