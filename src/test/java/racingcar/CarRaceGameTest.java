package racingcar;

import model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.CarRaceGame.makePlayers;
import static racingcar.CarRaceGame.saveName;

class CarRaceGameTest {

    @DisplayName("saveName 메서드 동작 테스트")
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

    @DisplayName("makePlayers 메서드 동작 테스트")
    @Test
    void makePlayersTest() {
        // given
        String[] userNames = {"pobi","woni"}; //saveName(); 입력
        //when
        Player[] players = makePlayers(userNames, userNames.length);
        //then
        assertThat(players[0].getName()).isEqualTo("pobi");
        assertThat(players[1].getName()).isEqualTo("woni");
    }


}