package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.TypeTransducer;

class PlayerTest {

    private final Player player = new Player();
    private final TypeTransducer typeTransducer = new TypeTransducer();

    @DisplayName("플레이어 닉네임을 등록하는 메서드 기능 테스트")
    @Test
    void registerMethodTest() {
        //given
        String input = "pobi,woni,jun";
        List<String> playerList = typeTransducer.strToList(input);

        //when
        for (String nickname : playerList) {
            player.register(nickname);
        }

        //then
        assertEquals(playerList.size(), player.getPlayer().size());
        assertTrue(player.getPlayer().containsKey(playerList.get(0)));
        assertTrue(player.getPlayer().containsKey(playerList.get(1)));
        assertTrue(player.getPlayer().containsKey(playerList.get(2)));
    }
}