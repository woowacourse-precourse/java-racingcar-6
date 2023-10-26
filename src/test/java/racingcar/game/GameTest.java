package racingcar.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void nameLengthTest(){
        MiniGame miniGame = new MiniGame();

        Assertions.assertThat(miniGame.checkNameLength("    ")).isEqualTo(false);
        Assertions.assertThat(miniGame.checkNameLength("asdasdf")).isEqualTo(false);
        Assertions.assertThat(miniGame.checkNameLength("asd")).isEqualTo(true);
    }

    @Test
    void setPlayersTest(){
        MiniGame miniGame = new MiniGame();

        String userNames = "abc, abd, adc";

        List<Player> players = miniGame.setPlayers(userNames);

        Assertions.assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void setPlayersExceptionTest(){
        MiniGame miniGame = new MiniGame();

        String userNames = "adbdc3, ab, add2";

        Assertions.assertThatThrownBy(
            ()->{
                miniGame.setPlayers(userNames);
            }
        ).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getChampionsTest(){
        MiniGame miniGame = new MiniGame();

        List<Player> players = new ArrayList<>();

        Player worm = new Player("worm");
        Player dog = new Player("dog");
        Player cat = new Player("cat");

        worm.forward();
        cat.forward();

        players.add(worm);
        players.add(dog);
        players.add(cat);

        List<Player> champions = miniGame.getChampions(players);

        Collections.sort(champions,
            new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        );

        Assertions.assertThat(champions.size()).isEqualTo(2);
        Assertions.assertThat(champions.get(0).getName()).isEqualTo("cat");
        Assertions.assertThat(champions.get(1).getName()).isEqualTo("worm");
    }

    // private 메서드 테스트 용도 내부 클래스
    static class MiniGame{
        boolean checkNameLength(String name){
            String removeSpace = name.trim();
            if(removeSpace.length()<=5 && removeSpace.length()>=1){
                return true;
            }
            return false;
        }

        private List<Player> setPlayers(String userNames){
            if(userNames.isEmpty()){
                throw new IllegalArgumentException();
            }

            String[] users = userNames.split(",");

            if(users.length==0){
                throw new IllegalArgumentException();
            }

            List<Player> playerList = new ArrayList<>();

            for(String user : users){
                if(checkNameLength(user)){
                    playerList.add(new Player(user));
                }else {
                    throw new IllegalArgumentException();
                }
            }

            return playerList;
        }

        private List<Player> getChampions( List<Player> players ){
            List<Player> champions = new ArrayList<>();

            if(players.size()==1){
                return players;
            }

            Collections.sort(players,
                (e1, e2)->{
                    return e2.getDistance()-e1.getDistance();
                }
            );

            champions.add(players.get(0));

            for(int i = 1 ; i<players.size(); i++){
                if(players.get(i).getDistance() == champions.get(0).getDistance()){
                    champions.add(players.get(i));
                }
            }

            return champions;
        }
    }
}
