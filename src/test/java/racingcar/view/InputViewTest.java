package racingcar.view;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Scanner;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputViewTest {

    private static InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes(UTF_8));
    }

    private static Stream<Arguments> provideCarNamesAndAttemptInput() {
        return Stream.of(
                Arguments.of("poby,woni,jun\n", "5"),
                Arguments.of("qm6,cona,k9\n", "2")
        );
    }

    private InputStream createInputStream(String carNames, String attempt) {
        return new SequenceInputStream(generateInput(carNames), generateInput(attempt));
    }

    @DisplayName("경주할 자동차 이름 목록과 시도 횟수 입력 테스트")
    @ParameterizedTest
    @MethodSource("provideCarNamesAndAttemptInput")
    void readLine_경주할_자동차_이름_목록과_시도_횟수_입력_테스트(String carNames, String attempt) {
        InputStream in = createInputStream(carNames, attempt);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        assertAll(
                () -> assertThat(scanner.nextLine())
                        .isEqualTo(carNames.trim()),
                () -> assertThat(scanner.nextLine())
                        .isEqualTo(attempt)
        );
    }
}