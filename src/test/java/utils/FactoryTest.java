package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import player.Player;

import java.util.*;

public class FactoryTest {

    @Test
    void testCreateRandomDigit(){
        //when
        int randomDigit = Factory.createRandomDigit();
        //then
        assertTrue(randomDigit >=0 && randomDigit <= 9);
    }
    @Test
    void testCreatePlayersArray() {
        // given
        List<String> playersName = Arrays.asList("pobi", "woni", "kim");

        // when
        List<Player> players = Factory.createPlayersArray(playersName);

        // then
        assertEquals(playersName.size(), players.size());
        for (int i = 0; i < playersName.size(); i++) {
            assertEquals(playersName.get(i), players.get(i).getPlayerName());
        }
    }

    @Test
    void LinkedHashMap_입력_순서_보장_확인() {
        //given
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("pobi");
        Player player2 = new Player("woni");
        Player player3 = new Player("crong");
        Collections.addAll(players, player2, player1, player3);

        for (Player player : players) {
            player.selectNewCar();
        }
        //when
        Map<String, Integer> playerDistanceMap = Factory.createPlayerDistanceMap(players);
        Set<String> playersName = playerDistanceMap.keySet();
        //then
        List<String> expectedOrder = Arrays.asList("woni", "pobi", "crong");
        List<String> actualOrder = new ArrayList<>(playersName);
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void Player의_distance가_Map에_잘_맵핑되었는지_확인() {
        //given
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("pobi");
        Player player2 = new Player("woni");
        Player player3 = new Player("crong");
        Collections.addAll(players, player2, player1, player3);
        //when
        // Gaem이 분배한 차를 Player가 선택 - 1라운드만 진행
        for (Player player : players) {
            player.selectNewCar();
            player.play();
        }
        Map<String, Integer> playerDistanceMap = Factory.createPlayerDistanceMap(players);
        Set<String> playersNameSet = playerDistanceMap.keySet();
        List<String> playersName = new ArrayList<>(playersNameSet);
        //then
        for (int i = 0; i < players.size(); i++) {
            // Map에 기록된 player의 distance
            // Player객체가 가지고 있는 distance 비교
            int distanceRecordedOnMap = playerDistanceMap.get(playersName.get(i));
            int distanceRecordOnPlayerObject = players.get(i).getDistance();
            assertEquals(distanceRecordedOnMap, distanceRecordOnPlayerObject);
        }
    }
}
