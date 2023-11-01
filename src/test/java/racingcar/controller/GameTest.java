package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    private String getSystemOutput() {
        return output.toString();
    }

    private InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    void setUp() {
        game = new Game();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void setEnd() {
        System.setOut(System.out);
        output.reset();
        camp.nextstep.edu.missionutils.Console.close();
    }

    @Test
    void setRace_사용자에게_자동차_이름을_입력받아_레이스의_Car_객체_리스트_초기화하는_메서드_호출() {
        //given
        System.setIn(createUserInput("dawin,woowa,han"));

        //when
        game.setRace();

        //then
        game.printResult();
        assertThat(getSystemOutput()).contains("dawin", "woowa", "han");
        assertThat(getSystemOutput()).doesNotContain("-");
    }

    @Test
    void setRound_사용자에게_이동_회수를_입력받아_이동_회수_설정하는_메서드_호출() {
        //given
        System.setIn(createUserInput("1"));

        //when
        game.setRound();

        //then
        assertThat(game.isRoundRemain()).isEqualTo(true);
    }

    @Test
    void isRoundRemain_이동_회수가_남아있는_경우_true_반환() {
        //given
        System.setIn(createUserInput("1"));
        game.setRound();

        //when
        boolean isRemain = game.isRoundRemain();

        //then
        assertThat(isRemain).isEqualTo(true);
    }

    @Test
    void isRoundRemain_이동_회수가_남아있지_않은_경우_false_반환() {
        //given
        System.setIn(createUserInput("1"));
        game.setRound();
        game.subtractOneRound();

        //when
        boolean isRemain = game.isRoundRemain();

        //then
        assertThat(isRemain).isEqualTo(false);
    }

    @Test
    void subtractOneRound_이동_회수를_1_차감하는_메서드_호출() {
        //given
        System.setIn(createUserInput("1"));
        game.setRound();

        //when
        boolean isRemainRoundOne = game.isRoundRemain();
        game.subtractOneRound();
        boolean isRemainRoundZero = game.isRoundRemain();

        //then
        assertThat(isRemainRoundOne).isEqualTo(true);
        assertThat(isRemainRoundZero).isEqualTo(false);
    }

    @Test
    void runSingleRound_랜덤값을_생성하고_자동차를_이동시키는_메서드_호출() {
        //given
        System.setIn(createUserInput("dawin,woowa,han"));
        game.setRace();

        //when
        for(int i = 0; i < 1000; i++) {
            game.runSingleRound();
        }

        //then
        game.printResult();
        assertThat(getSystemOutput()).contains("dawin", "woowa", "han", "-");
    }

    @Test
    void printResultStart_결과_출력_시작_메시지를_출력하는_메서드_호출() {
        //given

        //when
        game.printResultStart();

        //then
        assertThat(getSystemOutput()).contains("실행 결과");
    }

    @Test
    void printResult_게임_결과를_계산하고_출력하는_메서드_호출() {
        //given
        System.setIn(createUserInput("dawin,woowa,han"));
        game.setRace();

        //when
        game.printResult();

        //then
        assertThat(getSystemOutput()).contains("dawin", "woowa", "han", ":");
    }

    @Test
    void printResultEnd_경기의_우승자를_출력하는_메서드_호출() {
        //given
        System.setIn(createUserInput("dawin,woowa,han"));
        game.setRace();

        //when
        game.printResultEnd();

        //then
        assertThat(getSystemOutput()).contains("최종 우승자 : ");
    }

}