package racingcar;

import org.mockito.internal.matchers.Null;
import racingcar.service.VerificationService;
import racingcar.view.InputValues;
import racingcar.view.OutputValues;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        VerificationService verificationService = new VerificationService();

        verificationService.countTypeCheck(null);
        // TODO: 프로그램 구현
    }
}
