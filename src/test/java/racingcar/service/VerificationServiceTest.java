package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificationServiceTest {
    VerificationService verificationService = new VerificationService();
    private final String testWord = "test";
    private final String testWordLength = "testtest";

    @Test
    @DisplayName("자동차 이름 입력 검증 테스트")
    void nameCheck() {

        Assertions.assertTrue(verificationService.nameCheck(testWord));
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> {
            verificationService.nameCheck(testWordLength);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countTypeCheck() {
         final String intTest = "123";
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> { verificationService.countTypeCheck(testWord);
        }).isInstanceOf(IllegalArgumentException.class);

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> { verificationService.countTypeCheck(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertTrue(verificationService.countTypeCheck(intTest));

    }
}