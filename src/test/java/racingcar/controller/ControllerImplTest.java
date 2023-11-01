package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerImplTest {
    private PlayerControllerImpl controller = new PlayerControllerImpl();


    @Test
    @DisplayName("addPlayer 중복 삽입 테스트")
    void addPlayer_중복삽입_테스트() {
        controller.addPlayer("희종");
        controller.addPlayer("희종");
        controller.addPlayer("희종");
        assertThat(controller.getPlayers().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("removePlayer 삭제 테스트")
    public void removePlayer_삭제_테스트() {
        controller.addPlayer("희종");
        controller.addPlayer("주현");
        controller.addPlayer("진우");
        controller.addPlayer("하람");
        controller.addPlayer("정은");
        controller.removePlayer("진우");
        assertThat(controller.getPlayers().size()).isEqualTo(4);
    }
}
