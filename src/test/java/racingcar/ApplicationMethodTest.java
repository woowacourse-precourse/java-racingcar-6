package racingcar;

import model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Application.makePlayers;
import static racingcar.Application.saveName;

public class ApplicationMethodTest {

    @DisplayName("Application 클래스 내 saveName 메서드 동작 테스트")
    @Test
    void saveNameTest(){
        //given
        String inputNames = "pobi,woni";
        //when
        String[] names = saveName(inputNames);
        //then
        assertThat(names).contains("woni", "pobi");
        assertThat(names).containsExactly("pobi", "woni");
    }

    @DisplayName("Application 클래스 makePlayers 메서드 동작 테스트")
    @Test
    void makePlayersTest() {
        // given
        String[] userNames = {"pobi","woni"};
        //when
        Player[] players = makePlayers(userNames, userNames.length);
        //then
        assertThat(players[0].getName()).isEqualTo("pobi");
        assertThat(players[1].getName()).isEqualTo("woni");
    }
}
