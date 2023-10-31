package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.Application.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_5글자_이상_예외_처리() {
        String input_name = "cristiano";
        assertThatThrownBy(() -> string_length_illegal_check(input_name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 입력받은_이름목록을_쉼표로_구분하여_리스트로_정상_반환_처리() {
        String input_line = "tiger,lion,pig,cow,dog,cat";

        List<String> expected_player_list = Arrays.asList("tiger", "lion", "pig", "cow", "dog", "cat");

        List<String> result = input_to_player_list(input_line);

        assertEquals(expected_player_list, result);
    }

    @Test
    void 시도할_횟수_입력에_대한_정상_입력_처리() {
        String input_str = "999";
        int expected_result = 999;

        int result = is_num(input_str);
        assertEquals(expected_result, result);
    }

    @Test
    void 시도할_횟수_입력에_대한_예외_처리() {
        String input_str = "abc";
        assertThatThrownBy(() -> is_num(input_str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("(공백없는)숫자만 입력할 수 있습니다.");
    }



    @Test
    void 입력받은_무작위_숫자에_대해_전진_혹은_멈춤_구분() {
        int random_number = 4;
        boolean expected_result = true;
        boolean result = is_move(random_number);
        assertEquals(expected_result, result);
    }

    @Test
    void 움직인_횟수를_입력받아_움직인_거리를_터미널에_출력(){
        int total_movement = 9;
        String expected_result = "---------";
        String result = show_movement(total_movement);
        assertEquals(expected_result, result);
    }


    @Test
    void 시도_차수마다_진행상황을_터미널에_출력 (){
        List<String> player_list = Arrays.asList("player1", "player2", "player3", "player4", "player5");
        int[] players_move = {1,2,3,4,5};

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));


        show_race(player_list, players_move);


        String[] result = outputStreamCaptor.toString().split(System.lineSeparator());

        assertEquals("player1 : -", result[0].trim());
        assertEquals("player2 : --", result[1].trim());
        assertEquals("player3 : ---", result[2].trim());
        assertEquals("player4 : ----", result[3].trim());
        assertEquals("player5 : -----", result[4].trim());

    }

    @Test
    void 플레이어들_중_가장_전진횟수가_많은_횟수_구하기() {
        int[] players_move = {5, 6, 7, 13, 15, 9, 10, 11, 14, 13};
        int expected_result = 15;

        int result = get_max_movement(players_move);
        assertEquals(expected_result, result);
    }

    @Test
    void 플레이어들_중_우승자가_있는_인덱스_구하기(){
        int[] players_move = {1,2,3,4,5,5,5,5,4,3};
        int max_movement = 5;
        List<Integer> expected_result = Arrays.asList(4,5,6,7);

        List<Integer> result = get_winner_idx_list(players_move, max_movement);
        assertEquals(expected_result, result);
    }

    @Test
    void 플레이어들_중_우승자_구하기(){
        List<String> player_list = Arrays.asList("player1", "player2", "player3", "player4", "player5");
        List<Integer> winner_idx_list = Arrays.asList(0,1,2,3);
        String expected_result = "최종 우승자 : player1, player2, player3, player4";

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        show_winner(player_list, winner_idx_list);
        assertEquals(expected_result, outputStreamCaptor.toString());


    }

    @Override

    public void runMain() {
        Application.main(new String[]{});
    }
}
