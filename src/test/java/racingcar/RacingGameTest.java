package racingcar;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RacingGameTest {

    public static RacingGame game;
    public static List<Player> players;
    public static ByteArrayOutputStream outputStreamCapture;

    public static String getSystemOutputToString(){
        return outputStreamCapture.toString();
    }

    public static void playerSetting(List<String> names, List<Integer> steps){
        players = new ArrayList<>();
        for(int i=0; i<names.size(); i++){
            Player p = new Player(names.get(i));
            p.step = steps.get(i);
            players.add(p);
        }
    }

    public static void resetOutputString(){
        outputStreamCapture.reset();
    }

    @BeforeAll
    static void init(){
        List<String> playerName = Arrays.asList("Hello", "World", "Chuns");
        List<Integer> playerStep = Arrays.asList(3, 4, 5);
        playerSetting(playerName, playerStep);
        game = new RacingGame();

        outputStreamCapture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCapture));
    }

    @AfterAll
    static void restore(){
        System.setOut(System.out);
        resetOutputString();
    }

    @Test
    @Order(1)
    void 우승자_선별하기(){
        Player winner = new Player("Chuns");
        winner.step = 5;
        List<Player> expect = Arrays.asList(winner);
        assertIterableEquals(game.chooseWinner(players), expect);
    }

    @Test
    @Order(1)
    void 우승자_출력하기(){
        Player winner = new Player("Chuns");
        winner.step = 5;
        game.printWinner(game.chooseWinner(players));
        String expect = String.format("최종 우승자 : %s\n", winner.getName());
        assertThat(getSystemOutputToString()).isEqualTo(expect);
    }

    @Test
    @Order(3)
    void 여러_우승자_선별하기(){
        List<String> names = Arrays.asList("Hello", "World", "Chuns");
        List<Integer> steps = Arrays.asList(3,5,5);
        playerSetting(names, steps);
        List<String> expect = Arrays.asList("World", "Chuns");
        List<Player> result = game.chooseWinner(players);
        for(int i=0; i<result.size(); i++){
            assertThat(result.get(i).getName()).isEqualTo(expect.get(i));
        }
    }

    @Test
    @Order(4)
    void 여러_우승자_출력하기(){
        resetOutputString();
        game.printWinner(game.chooseWinner(players));
        String expect = String.format("최종 우승자 : %s\n", "World, Chuns");
        assertThat(getSystemOutputToString()).isEqualTo(expect);
    }


}
