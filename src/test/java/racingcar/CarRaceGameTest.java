package racingcar;

import model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.CarRaceGame.*;

class CarRaceGameTest {

    @DisplayName("generateRandomNumber 메서드 동작 테스트")
    @Test
    void generateRandomNumberTest() {
        // given
        Player[] players = new Player[3];
        for(int i = 0; i < players.length; i++)
            players[i] = new Player("Player " + i);

        //when
        generateRandomNumber(players);
        //then
        for(Player player : players) {
            int randomNumber = player.getRandomNumber();
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
            System.out.println("1");
        }
    }

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(outputStream));
    }
    @AfterEach
    public void restoreStreams(){
        System.setOut(System.out);
    }

    @DisplayName("printResult 메서드 동작 테스트 랜덤 값이 4 이상일때")
    @Test
    void printResultMore4Test() {
        //given
        Player[] players = new Player[1];
        players[0] = new Player("Player");

        //when
        players[0].setRandomNumber(9);
        printResult(players);

        //then
        String consoleOutput  = outputStream.toString().trim();

        String expectedOutput = "Player : -";
        assertEquals(consoleOutput,expectedOutput);

    }

    @DisplayName("printResult 메서드 동작 테스트 랜덤 값이 4 미만일때")
    @Test
    void printResultUnder4Test() {
        //given
        Player[] players = new Player[1];
        players[0] = new Player("Player");

        //when
        players[0].setRandomNumber(3);
        printResult(players);

        //then
        String consoleOutput  = outputStream.toString().trim();

        String expectedOutput = "Player :";
        assertEquals(consoleOutput,expectedOutput);

    }

    @DisplayName("getMaxDistance 메서드 동작 테스트")
    @Test
    void getMaxDistanceTest(){
        //given
        Player[] players = new Player[3];
        for(int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + i);
            players[i].setDistance(i);
        }
        //when
        int maxDistance = getMaxDistance(players);

        //then
        assertThat(players[2].getDistance()).isEqualTo(maxDistance);
    }
    @DisplayName("getWinner 메서드 동작 테스트(우승자가 한명일때)")
    @Test
    void getSoloWinnerTest(){
        //given
        Player[] players = new Player[3];
        for(int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + i);
            players[i].setDistance(i);
        }

        //when
        List<String> winners = getWinner(players);

        //then
        assertThat(players[2].getName()).isEqualTo(winners.get(0));
    }

    @DisplayName("getWinner 메서드 동작 테스트(우승자가 여러명일때)")
    @Test
    void getNotSoloWinnerTest(){
        //given
        Player[] players = new Player[3];
        for(int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + i);
            players[i].setDistance(1);
        }

        //when
        List<String> winners = getWinner(players);

        //then
        assertThat(players[0].getName()).isEqualTo(winners.get(0));
        assertThat(players[1].getName()).isEqualTo(winners.get(1));
        assertThat(players[2].getName()).isEqualTo(winners.get(2));
    }
}