package study;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.Object.Car;
import racingcar.Object.Player;
import racingcar.Object.RandomNumberGenerator;
import racingcar.game.InputManager;
import racingcar.game.Game;
import racingcar.game.GameCar;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    @Test
    void move_차_이동_테스트() {
        //given
        Car car = new Car();
        //when
        int position = car.move(1);
        //then;
        assertThat(position).isEqualTo(2);
    }
    @Test
    void move_게임_차_이동_테스트() {
        //given
        GameCar gameCar = new GameCar("choi");
        //when
        gameCar.move();
        //then
        assertThat(gameCar.getPosition()).isEqualTo(1);
    }

    @Test
    void moveGameCar_랜덤값에따라_차_이동_테스트(){
        //given
        List<String> carNameList = InputManager.parseCarName("choi,jong,geun");
        int turn = InputManager.parseIntTurnAnswer("5");
        Game game = new Game(turn,carNameList);

        //when
        game.moveGameCars();

        //then;
        List<Integer> gameScore = game.getGameScore();
        System.out.println(gameScore.get(0));
        System.out.println(gameScore.get(1));
        System.out.println(gameScore.get(2));
    }

    @Test
    void readLine_테스트() {
        //given
        Player player = new Player();
        InputStream in = new ByteArrayInputStream("abc".getBytes());
        System.setIn(in);
        //when
        String inputAnswer = player.inputAnswer();
        //then;
        assertThat(inputAnswer).isEqualTo("abc");
    }

    @Test
    void parseCarName_성공_테스트() {
        //given
        InputManager inputManager = new InputManager();
        //when
        List<String> parseCarName = inputManager.parseCarName("choi,jong");
        //then
        assertThat(parseCarName.get(0)).isEqualTo("choi");
        assertThat(parseCarName.get(1)).isEqualTo("jong");

    }

    @Test
    void parseCarName_6글자_이상_실패_테스트() {
        //given
        InputManager inputManager = new InputManager();
        //when

        //then
        assertThatThrownBy(() -> inputManager.parseCarName("choi06,jong"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름은 5글자 이하로 해주세요.");

    }
    @Test
    void parseIntTurnAnswer_성공_테스트() {
        //given
        InputManager inputManager = new InputManager();
        //when
        int answer = inputManager.parseIntTurnAnswer("5");
        //then
        assertThat(answer).isEqualTo(5);

    }

    @Test
    void parseIntTurnAnswer_6글자_이상_실패_테스트() {
        //given
        InputManager inputManager = new InputManager();
        //when

        //then
        assertThatThrownBy(() -> inputManager.parseIntTurnAnswer("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요.");

    }

    @Test
    void displayGameScore_테스트() {
        //given
        List<String> gameCars = new ArrayList<>(Arrays.asList("choi","jong"));
        Game game = new Game(1,gameCars);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        game.displayGameScore();
        //then
        assertThat(out.toString()).isEqualTo("choi : \njong : \n");
    }

    @Test
    void displayGameWinner_테스트() {
        //given
        List<String> gameCars = new ArrayList<>(Arrays.asList("choi"));
        Game game = new Game(1,gameCars);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        game.displayGameWinner();
        //then
        assertThat(out.toString()).isEqualTo("최종 우승자 : choi");
    }

}
