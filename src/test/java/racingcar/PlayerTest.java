package racingcar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {

    public static Player testPlayer;
    public static ByteArrayOutputStream outputStreamForCapture;

    public String getSystemOutputToString(){
        return outputStreamForCapture.toString();
    }

    @BeforeAll
    static void init(){
        testPlayer = new Player("testPlayer");
        outputStreamForCapture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamForCapture));
    }

    @AfterAll
    static void restore(){
        System.setOut(System.out);
        outputStreamForCapture.reset();
    }

    @Test
    void 플레이어가_움직일_수_있는지_확인(){
        assertThat(testPlayer.movable(5)).isTrue();
        assertThat(testPlayer.movable(3)).isFalse();
    }

    @Test
    void 플레이어가_움직인_거리_확인(){
        int interval = 5;
        for(int i=0; i<interval; i++){
            testPlayer.move();
        }
        String testPlayerRoadResult = testPlayer.makeRoad();
        assertThat(testPlayer.step).isEqualTo(testPlayerRoadResult.length());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<testPlayer.step; i++){
            sb.append("-");
        }
        assertThat(sb.toString()).isEqualTo(testPlayerRoadResult);
    }

    @Test
    void 플레이어_스탭_확인(){
        testPlayer.print();
        String expected = String.format("%s : %s\n", testPlayer.getName(), testPlayer.makeRoad());
        assertThat(getSystemOutputToString()).isEqualTo(expected);
    }

    @Test
    void 플레이어_스탭_비교(){
        List<String> names = Arrays.asList("Hello", "World");
        List<Player> players = names.stream()
                .map(name -> new Player(name)).collect(Collectors.toList());
        List<Integer> steps = Arrays.asList(1,2);

        for(int i=0; i<steps.size(); i++){
            players.get(i).step = steps.get(i);
        }
        assertThat(players.get(0).compareTo(players.get(1))).isEqualTo(-1);
    }

    @Test
    void 같은_이름의_플레이어_비교확인(){
        Player comparePlayer = new Player(testPlayer.getName());
        assertThat(testPlayer.equals(comparePlayer)).isTrue();

        Player playerHasAnotherName = new Player("mickeyshoes");
        assertThat(testPlayer.equals(playerHasAnotherName)).isFalse();
    }
}
