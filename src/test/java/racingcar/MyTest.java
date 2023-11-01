package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class MyTest extends NsTest {
    private final GameUtil gameUtil = new GameUtil();

    @Test
    void 한_칸_움직이면_한_줄_추가된다() {
        Racer racer = new Racer("이름");
        assertThat(racer.getScore()).isEqualTo("");
        racer.move();
        assertThat(racer.getScore()).isEqualTo("-");
    }

    @Test
    void 이름이_너무_깁니다() {
        String input = "엄청긴이름입니다";
        assertThatThrownBy(() -> gameUtil.inputToNameList(input))
                .hasMessageContaining("이름은 한 글자 이상 다섯 글자 이하여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_너무_짧습니다() {
        assertThatThrownBy(() -> gameUtil.inputToNameList(" , "))
                .hasMessageContaining("이름은 한 글자 이상 다섯 글자 이하여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 차수_결과를_출력합니다() {
        List<Racer> racerList = new ArrayList<>();
        racerList.add(new Racer("첫 번째"));
        racerList.add(new Racer("김"));
        racerList.add(new Racer("더벤티선수"));

        racerList.get(2).move();
        gameUtil.printEachResult(racerList);
        assertThat(output()).contains("첫 번째 : ", "김 : ", "더벤티선수 : -");
    }

    @Test
    @DisplayName("혼자 우승")
    void 방장_사기_맵입니다() {
        try (MockedStatic<Console> console = mockStatic(Console.class);
             MockedStatic<Randoms> random = mockStatic(Randoms.class)) {
            when(Console.readLine()).thenReturn("방장,유저1,유저2", "3");
            when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 4, 3, 4, 4, 3, 4, 3, 4);
            Application game = new Application();
            game.gameStart();
        }
        assertThat(output()).contains("방장 : -", "유저1 : -", "유저2 : ", "방장 : --", "유저1 : --", "유저2 : ", "방장 : ---",
                "유저1 : ",
                "유저2 : -", "최종 우승자 : 방장");
    }

    @Test
    void 세_명_모두_우승입니다() {
        try (MockedStatic<Console> console = mockStatic(Console.class);
             MockedStatic<Randoms> random = mockStatic(Randoms.class)) {
            when(Console.readLine()).thenReturn("유저1,유저2,유저3", "3");
            when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
            Application game = new Application();
            game.gameStart();
        }
        assertThat(output()).contains("유저1 : -", "유저2 : -", "유저3 : -", "유저1 : --", "유저2 : --", "유저3 : --", "유저1 : ---",
                "유저2 : ---",
                "유저3 : ---", "최종 우승자 : 유저1, 유저2, 유저3");
    }

    @Test
    void 올바른_횟수를_입력해주세요() {
        assertThatThrownBy(() -> {
            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                when(Console.readLine()).thenReturn("이름1,이름2,이름3", "숫자가아닙니다.");
                Application game = new Application();
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }

    @Test
    void 이름이_중복될_수_없습니다(){
        assertThatThrownBy(() -> {
            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                when(Console.readLine()).thenReturn("중복,중복,중복", "3");
                Application game = new Application();
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름입니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}