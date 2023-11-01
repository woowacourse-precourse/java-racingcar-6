package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.policy.MovingPolicy;
import racingcar.policy.NumberGeneratePolicy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RuleTest {

    @Test
    void 규칙에_따라_움직일_수_있다면_움직인다() {
        //given
        NumberGeneratePolicy numberGeneratePolicy = () -> 10;
        MovingPolicy movingPolicy = num -> true;
        Rule rule = new Rule(movingPolicy, numberGeneratePolicy);

        // when, then
        assertThat(rule.canMove()).isTrue();
    }

    @Test
    void 규칙에_따라_움직일_수_없다면_움직이지_않는다() {
        //given
        NumberGeneratePolicy numberGeneratePolicy = () -> 10;
        MovingPolicy movingPolicy = num -> false;
        Rule rule = new Rule(movingPolicy, numberGeneratePolicy);

        // when, then
        assertThat(rule.canMove()).isFalse();
    }

}
