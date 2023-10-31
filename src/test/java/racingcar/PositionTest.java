package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

@DisplayName("Position 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PositionTest {

    @Test
    void increase_메소드는_position을_증가시킨다() {
        Position position = new Position();

        position.increase();

        Assertions.assertEquals(position.getPosition(), 1);
    }
}
