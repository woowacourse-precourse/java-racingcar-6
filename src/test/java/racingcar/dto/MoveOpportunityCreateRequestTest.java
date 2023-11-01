package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoveOpportunityCreateRequestTest {

    @Test
    public void 숫자_스트링을_통해_객체를_생성할_수_있다() throws Exception {
        // given
        String moveOpportunity = "123";

        // when
        //then
        assertThatCode(() -> {
            new MoveOpportunityCreateRequest(moveOpportunity);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 숫자가_아닌_스트링을_통해_객체를_생성하면_예외가_발생한다() throws Exception {
        // given
        String moveOpportunity = "AA";

        // when
        //then
        assertThatThrownBy(() -> {
            new MoveOpportunityCreateRequest(moveOpportunity);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}