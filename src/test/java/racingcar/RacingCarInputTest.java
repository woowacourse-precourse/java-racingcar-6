package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarInputTest {
    @Test
    void 콤마_단위로_리스트에_나누는_기능() {
        String input = "a,b,c";
        String input2 = "a, b, c";
        String input3 = ",a,b";
        List<String> result = Arrays.asList(input.split(","));
        List<String> result2 = Arrays.asList(input2.split(","));
        List<String> result3 = Arrays.asList(input3.split(","));

        assertThat(result).contains("b", "a", "c");
        assertThat(result).containsExactly("a", "b", "c");

        assertThat(result2).contains(" b", "a", " c");
        assertThat(result2).containsExactly("a", " b", " c");

        assertThat(result3).contains("", "b", "a");
        assertThat(result3).containsExactly("", "a", "b");
    }

    @Test
    void 무작위_랜덤숫자_생성() {
        int result = PickNum.pickNum();
        assertThat(result).isBetween(0, 9);
    }

    @Test
    void 랜덤숫자를_통해_자동차가_움직일지_말지_결정() {
        int result = 7;
        assertThat(CarMovement.isMove(result)).isIn(true);

        result = 2;
        assertThat(CarMovement.isMove(result)).isIn(false);
    }

    @Test
    void 해쉬맵에_리스트에_있는_원소를_키_값으로_넣음() {
        List<String> list1 = List.of("pobi", "woni", "crong");
        String str = "";
        HashMap<String, String> hm1 = new HashMap<>();

        CarMovement.putHM(hm1, list1, str);

        assertThat(hm1).containsKeys("pobi", "woni", "crong");
        assertThat(hm1).containsValues("");

        List<String> list2 = List.of("a ", " ", "b");
        HashMap<String, String> hm2 = new HashMap<>();

        CarMovement.putHM(hm2, list2, "123");

        assertThat(hm2).containsKeys("a ", " ", "b");
        assertThat(hm2).containsValues("123");
    }

    @Test
    void 우승자를_선정하는_기능() {
        GameManager gm = new GameManager();
        List<String> members = List.of("pobi", "woni", "crong");
        HashMap<String, String> hm = new HashMap<>();
        hm.put("pobi", "---");
        hm.put("woni", "--");
        hm.put("crong", "-----");
        assertThat(gm.whoIsWinner(hm, members)).contains("crong");

        hm.put("woni", "-----");
        assertThat(gm.whoIsWinner(hm, members)).contains("crong", "woni");
    }

    @Test
    void 우승자를_출력하는_기능() {
        List<String> winner = List.of("woni", "crong");
        assertThat(Print.winner(winner)).isEqualTo("최종 우승자 : woni, crong");
    }
}
