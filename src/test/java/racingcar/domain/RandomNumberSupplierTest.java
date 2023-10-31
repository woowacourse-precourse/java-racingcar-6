package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

@SuppressWarnings("NonAsciiCharacters")
class RandomNumberSupplierTest {

    @RepeatedTest(20)
    void 숫자_0에서_9사이의_무작위_값을_제공할_수_있다() {
        RandomNumberSupplier randomNumberSupplier = RandomNumberSupplier.getInstance();

        int actual = randomNumberSupplier.getAsInt();

        assertThat(actual).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
