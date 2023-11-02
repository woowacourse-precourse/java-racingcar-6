package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.opportunityvalidator.OpportunityValidator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OpportunityValidatorTest {
    @Test
    void validateOpportunityTest() {
        // Given
        String ex1 = "-1";
        String ex2 = "abc";
        String ex3 = "0";
        OpportunityValidator opportunityValidator = new OpportunityValidator();

        // When and Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> opportunityValidator.validateOpportunity(ex1))
                .withMessage("시도 횟수는 1 이상이어야 합니다.");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> opportunityValidator.validateOpportunity(ex2))
                .withMessage("시도 횟수는 숫자여야 합니다.");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> opportunityValidator.validateOpportunity(ex3))
                .withMessage("시도 횟수는 1 이상이어야 합니다.");
    }
}
