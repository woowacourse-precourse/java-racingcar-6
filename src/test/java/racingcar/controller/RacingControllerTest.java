package racingcar.controller;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Player;

class RacingControllerTest {

    @DisplayName("우승자를 가리는 테스트")
    @Test
    public void 우승자를_가리는_테스트() throws Exception {
        // given
        RacingController rcController = new RacingController();

        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");

        Method addForwardP1 = p1.getClass().getDeclaredMethod("addForward");
        addForwardP1.setAccessible(true);
        addForwardP1.invoke(p1);
        addForwardP1.invoke(p1); // p1은 2번 움직임

        Method addForwardP2 = p2.getClass().getDeclaredMethod("addForward");
        addForwardP2.setAccessible(true);
        addForwardP2.invoke(p2); // p2는 1번 움직임

        Method addForwardP3 = p3.getClass().getDeclaredMethod("addForward");
        addForwardP3.setAccessible(true);
        addForwardP3.invoke(p3);
        addForwardP3.invoke(p3); // p3는 2번 움직임

        Field players = rcController.getClass().getDeclaredField("players");
        players.setAccessible(true);
        players.set(rcController, new ArrayList<>(List.of(p1, p2, p3))); // 이름들을 등록한다

        // when
        Method winner = rcController.getClass().getDeclaredMethod("winner");
        winner.setAccessible(true);
        ArrayList<String> invoke = (ArrayList<String>) winner.invoke(rcController);

        // then
        ArrayList<String> res = new ArrayList<>();
        res.add("p1");
        res.add("p3");

        Assertions.assertThat(invoke).isEqualTo(res); // p1과 p3는 총 2번 움직였기 때문에 우승해야 한다.
    }
}