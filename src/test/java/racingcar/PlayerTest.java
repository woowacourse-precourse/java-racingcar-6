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
    /*
    given(준비): 어떠한 데이터가 준비되었을 때
    when(실행): 어떠한 함수를 실행하면
    then(검증): 어떠한 결과가 나와야 한다.
     */
    private Player player;
    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("플레이어_설정_확인")
    @Test
    void setThePlayer() {
        //given(준비): 어떠한 데이터가 준비되었을 때 - input data = 'pobi,woni,jun'입력했을때
        String inputData = "pobi,woni,jun";
        //when(실행): 어떠한 함수를 실행하면 - setThePlayer() 실행하면
        List<String> playerList = player.setThePlayer(inputData);
        //then(검증): 어떠한 결과가 나와야 한다. - playerList가 'pobi','woni','jun'을 정확히 일치하게 포함한다.
        assertThat(playerList).isEqualTo(Arrays.asList("pobi", "woni", "jun"));

    }

    @DisplayName("리스트_길이_일치_여부")
    @Test
    void setScore() {
        //given(준비):어떠한 데이터가 준비되었을 때 - input data = 'pobi,woni,jun'입력했을때
        String inputData = "pobi,woni,jun";
        List<String> playerList = player.setThePlayer(inputData);
        //when(실행): 어떠한 함수를 실행하면 - setScore() 실행하면
        List<Integer> scoreList = player.setScore(playerList);
        //then(검증): 어떠한 결과가 나와야 한다. - platerList와 scroreList의 길이가 일치해야한다.
        assertThat(scoreList).hasSize(playerList.size());
    }

    @Test
    void lengthException(){
        //given(준비): 어떠한 데이터가 준비되었을 때 - input data = 'pobi,woni,hyejii'입력했을 때
        String inputData = "pobi,woni,hyejii";
        //when(실행): 어떠한 함수를 실행하면 - setThePlayer() 실행하면
        //then(검증): 어떠한 결과가 나와야 한다. - IllegalArgumentException 발생해야한다.
        assertThrows(IllegalArgumentException.class, () -> player.setThePlayer(inputData));

    }


}