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

        // Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> opportunityValidator.validateOpportunity(ex1));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> opportunityValidator.validateOpportunity(ex2));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> opportunityValidator.validateOpportunity(ex3));
    }
}
