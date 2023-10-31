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
    void 이름이_너무_깁니다(){
        String input = "엄청긴이름입니다";
        assertThatThrownBy(() -> gameUtil.inputToNameList(input))
                .hasMessageContaining("이름은 한 글자 이상 다섯 글자 이하여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_너무_짧습니다(){
        assertThatThrownBy(() -> gameUtil.inputToNameList(" , "))
                .hasMessageContaining("이름은 한 글자 이상 다섯 글자 이하여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 차수_결과를_출력합니다(){
        List<Racer> racerList = new ArrayList<>();
        racerList.add(new Racer("첫 번째"));
        racerList.add(new Racer("김"));
        racerList.add(new Racer("더벤티선수"));

        racerList.get(2).move();
        gameUtil.printEachResult(racerList);
        assertThat(output()).contains("첫 번째 : ", "김 : ", "더벤티선수 : -");
    }

    @Test
    void 방장_사기_맵_세_차수_실행한다(){
        try(MockedStatic<Console> console = mockStatic(Console.class);
            MockedStatic<Randoms> random = mockStatic(Randoms.class)) {
            when(Console.readLine()).thenReturn("방장,유저1,유저2", "3");
            when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 4, 3, 4, 4, 3, 4, 3, 4);
            Game game = new Game();
            game.gameStart();
        }
        assertThat(output()).contains("방장 : -", "유저1 : -", "유저2 : ", "방장 : --", "유저1 : --", "유저2 : ", "방장 : ---", "유저1 : ",
                "유저2 : -", "최종 우승자 : 방장");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}