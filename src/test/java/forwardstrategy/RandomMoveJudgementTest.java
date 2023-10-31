package forwardstrategy;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;


import domain.RandomMoveJudgement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import util.generator.RandomNumberGenerator;

public class RandomMoveJudgementTest {

    @BeforeEach
    public void setUp() {
        mockStatic(RandomNumberGenerator.class);
    }

    @AfterEach
    public void tearDown() {
        Mockito.framework().clearInlineMocks();
    }

    @ParameterizedTest
    @DisplayName("랜덤 정수 전진 가능 테스트")
    @ValueSource(ints = {4,5, 6, 7, 8, 9})
    void canMoveTest(int value) {
        //given
        when(RandomNumberGenerator.generateRandomNumber()).thenReturn(value);
        RandomMoveJudgement forwardStrategy = new RandomMoveJudgement();

        //then
        assertThat(forwardStrategy.canMove()).isTrue();
    }


    @ParameterizedTest
    @DisplayName("랜덤 정수 전진 불가능 가능 테스트")
    @ValueSource(ints = {1, 2, 3})
    void canNotMoveTest(int value) {
        //given
        when(RandomNumberGenerator.generateRandomNumber()).thenReturn(value);
        RandomMoveJudgement forwardStrategy = new RandomMoveJudgement();

        //then
        assertThat(forwardStrategy.canMove()).isFalse();
    }
}