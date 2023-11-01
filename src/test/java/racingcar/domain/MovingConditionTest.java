package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovingConditionTest {
    private MovingCondition movingCondition;

    @BeforeEach
    void setUp() {
        movingCondition = new MovingCondition();
    }
}