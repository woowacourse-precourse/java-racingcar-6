package racingcar.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarResponseDtoTest {
    private List<String> carNames;
    private CarResponseDto carResponseDto;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("pobi", "woni");
        carResponseDto = new CarResponseDto(carNames);
    }

    @Test
    @DisplayName("CarResponse 생성자를 테스트 합니다.")
    void CarResponseDto_생성자_확인() {
        assertThat(carResponseDto).isNotNull();
        assertThat(carResponseDto).extracting(CarResponseDto::getCarNames).isEqualTo(carNames);
    }

    @Test
    @DisplayName("우승자 결과 변환을 테스트 합니다.")
    void 우승자_결과_변환() {
        assertThat(carResponseDto).extracting(CarResponseDto::getWinnerCarNames).isEqualTo("pobi,woni");
    }
}