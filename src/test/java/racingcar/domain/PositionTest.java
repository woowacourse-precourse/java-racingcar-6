package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Position 클래스")
class PositionTest {

    private Position position;

    @BeforeEach
    void setup() {
        position = new Position();
    }

    @Test
    void Position_생성시_자동으로_초기값_생성() {
        assertThat(position.getPosition()).isEqualTo(0);
    }
}