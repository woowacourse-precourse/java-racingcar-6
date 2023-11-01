package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TrialValidationServiceTest {
    private TrialValidationService trialValidationService;

    @BeforeEach
    void setUp() {
        trialValidationService = new TrialValidationService();
    }

    @Nested
    @DisplayName("정상 작동 테스트")
    class NormalTests {
        @Test
        @DisplayName("정상 입력 테스트")
        void shouldValidateCorrectTrial() {
            trialValidationService.validateTrial("5");
        }
    }

    @Nested
    @DisplayName("예외 처리 테스트")
    class ExceptionTests {
        @Test
        @DisplayName("공백 입력 테스트")
        void shouldThrowExceptionForBlankInput() {
            assertThatThrownBy(() -> trialValidationService.validateTrial(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("공백은 입력 불가");
        }

        @Test
        @DisplayName("정수 이외 입력 테스트")
        void shouldThrowExceptionForNonInteger() {
            assertThatThrownBy(() -> trialValidationService.validateTrial("abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("정수만 입력 가능");
        }

        @Test
        @DisplayName("실수 입력 테스트")
        void shouldThrowExceptionForDouble() {
            assertThatThrownBy(() -> trialValidationService.validateTrial("1.0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("정수만 입력 가능");
        }

        @Test
        @DisplayName("음수 입력 테스트")
        void shouldThrowExceptionForNegativeInteger() {
            assertThatThrownBy(() -> trialValidationService.validateTrial("-5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("양의 정수만 입력 가능");
        }
    }
}
