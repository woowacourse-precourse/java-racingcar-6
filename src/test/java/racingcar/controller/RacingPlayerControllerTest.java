package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingPlayerControllerTest {
    private RacingPlayerController controller = new RacingPlayerController();


    @Test
    @DisplayName("addPlayer_중복 삽입 테스트")
    void addPlayer_중복삽입_테스트(){
        controller.addPlayer("희종");
        controller.addPlayer("희종");
        controller.addPlayer("희종");
        assertThat(controller.getPlayers().size()).isEqualTo(1);
    }
}
