package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarProgressResponse;

class GameResultTest {

    private final List<String> winners = List.of("benz", "car");
    private final List<CarProgressResponse> progressResponses = List.of(
        new CarProgressResponse("benz", 3),
        new CarProgressResponse("car", 2));
    private final List<String> emptyWinner = new ArrayList<>();
    private final List<CarProgressResponse> emptyProgress = new ArrayList<>();

    @Test
    void constructor_성공() {
        GameResult gameResult = new GameResult(progressResponses, winners);

        assertAll(
            () -> assertThat(gameResult.progressResponses()).isEqualTo(progressResponses),
            () -> assertThat(gameResult.winners()).isEqualTo(winners)
        );
    }
    @Test
    void constructor_레이싱_결과는_필수() {
        assertThatNullPointerException()
            .isThrownBy(() -> new GameResult(null, winners));
    }
    @Test
    void constructor_우승자는_필수() {
        assertThatNullPointerException()
            .isThrownBy(() -> new GameResult(progressResponses, null));
    }
    @Test
    void constructor_레이싱_결과는_하나_이상이어야_한다() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new GameResult(emptyProgress, winners));
    }
    @Test
    void constructor_우승자는_하나_이상이어야_한다() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new GameResult(progressResponses, emptyWinner));
    }
}