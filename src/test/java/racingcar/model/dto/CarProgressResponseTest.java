package racingcar.model.dto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarProgressResponse;

class CarProgressResponseTest {
    private final int result = 3;
    @Test
    void constructor_성공() {
        final String name = "benz";

        CarProgressResponse response = new CarProgressResponse(name, result);

        assertAll(
            () -> assertThat(response.name()).isEqualTo(name),
            () -> assertThat(response.result()).isEqualTo(result)
        );
    }
    @Test
    void constructor_차량_이름은_필수() {
        assertThatNullPointerException()
            .isThrownBy(() -> new CarProgressResponse(null, result));
    }
}