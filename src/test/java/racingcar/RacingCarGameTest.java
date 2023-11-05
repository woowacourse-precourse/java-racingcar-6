package racingcar;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;
import racingcar.randomvalue.RandomValueGenerator;
import racingcar.result.RacingCarResultFormatter;

class RacingCarGameTest {

    private RacingCarGame racingCarGame;

    private RandomValueGenerator randomValueGenerator;

    private UserIo userIo;

    @BeforeEach
    public void setUp() {
        randomValueGenerator = mock(RandomValueGenerator.class);
        userIo = mock(UserIo.class);

        racingCarGame = new RacingCarGame(
                new RacingGameInteractionHandler(userIo, new CarNameParser(), new RacingCarResultFormatter()),
                new CarMovementDecider(randomValueGenerator)
        );
    }


    @DisplayName("pobi가 항상 우승하도록 시뮬레이션")
    @Test
    void givenConditions_pobiAlwaysWins() {
        // Given
        given(userIo.readLine()).willReturn("pobi,woni,jun", "3");
        given(randomValueGenerator.generate()).willReturn(5, 0, 5, 5, 0, 0, 0, 0, 0);

        // When
        racingCarGame.run();

        // Then
        verify(userIo, times(1)).print("최종 우승자 : pobi");
    }
}
