package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarRacer;
import racingcar.domain.Game;

import static org.assertj.core.api.Assertions.*;

public class FeatureTest {

    private CarRacer carRacer;
    private Game game;

    @BeforeEach
    void setUp() {
        carRacer = new CarRacer();
        game = new Game();
    }

    @ParameterizedTest
    @ValueSource(strings = {"red,blue,yellow", "red, blue", "red"})
    void 자동차_이름_잘못입력_예외처리(String input){
        assertThatThrownBy(() -> carRacer.createCarRacer(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차대회_참가자_인원_확인(){
        String input = "red,blue,coco";
        carRacer.createCarRacer(input);

        assertThat(carRacer.getParticipants().size())
                .isEqualTo(3);
    }

    @Test
    void 시도할_회수_문자입력(){
        String input = "1n";
        assertThatThrownBy(() -> game.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
