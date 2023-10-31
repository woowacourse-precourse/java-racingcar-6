package racingcar;

import model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.CarRaceGame.*;

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
        String[] userNames = {"pobi","woni"};
        //when
        Player[] players = makePlayers(userNames, userNames.length);
        //then
        assertThat(players[0].getName()).isEqualTo("pobi");
        assertThat(players[1].getName()).isEqualTo("woni");
    }


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
        printResult(players);
        players[0].setRandomNumber(9);

        //then
        String consoleOutput  = outputStream.toString().trim();

        String expectedOutput = "Player : -";
        assertEquals(consoleOutput,expectedOutput);

    }

    @DisplayName("printResult 메서드 동작 테스트 랜덤 값이 4 이하일때")
    @Test
    void printResultUnder4Test() {
        //given
        Player[] players = new Player[1];
        players[0] = new Player("Player");

        //when
        printResult(players);
        players[0].setRandomNumber(9);

        //then
        String consoleOutput  = outputStream.toString().trim();

        String expectedOutput = "Player : -";
        assertEquals(consoleOutput,expectedOutput);

    }
}