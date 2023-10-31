package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.TypeTransducer;

class PlayerTest {

    private final Player player = new Player();

    @DisplayName("플레이어 닉네임을 등록하는 메서드 기능 테스트")
    @Test
    void registerNicknameMethodTest() {
        //given
        String input = "pobi,woni,jun";
        List<String> playerList = TypeTransducer.strToList(input);

        //when
        for (String nickname : playerList) {
            player.registerNickname(nickname);
        }

        //then
        assertEquals(playerList.size(), player.getPlayer().size());
        assertTrue(player.getPlayer().containsKey(playerList.get(0)));
        assertTrue(player.getPlayer().containsKey(playerList.get(1)));
        assertTrue(player.getPlayer().containsKey(playerList.get(2)));
    }

    @DisplayName("자동차 경주 시도 회수를 등록하는 메서드 기능 테스트")
    @Test
    void registerGameTimeMethodTest() {
        //given
        String inputGameTime = "5";
        Integer registerGameTime = Integer.parseInt(inputGameTime);

        //whem
        player.registerGameTime(inputGameTime);

        //then
        assertEquals(player.getGameTime(), registerGameTime);
    }

    @DisplayName("자동차 경주의 우승자(1명)를 List 타입으로 반환하는 메서드 기능 테스트")
    @Test
    void getWinnerMethodTest() {
        //given
        player.registerNickname("pobi");
        player.registerNickname("woni");
        player.registerNickname("jun");

        player.getPlayer().put("pobi", 3);
        player.getPlayer().put("woni", 2);
        player.getPlayer().put("jun", 1);

        //when
        List<String> winners = player.getWinner();

        //then
        assertEquals(1, winners.size());
        assertTrue(winners.contains("pobi"));
    }

    @DisplayName("자동차 경주의 우승자(여러 명)를 List 타입으로 반환하는 메서드 기능 테스트")
    @Test
    void getWinnersMethodTest() {
        //given
        player.registerNickname("pobi");
        player.registerNickname("woni");
        player.registerNickname("jun");

        player.getPlayer().put("pobi", 3);
        player.getPlayer().put("woni", 3);
        player.getPlayer().put("jun", 1);

        //when
        List<String> winners = player.getWinner();

        //then
        assertEquals(2, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
    }
}