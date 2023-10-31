package racingcar.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarResponseDtoTest {
    private final String carName1 = "pobi";
    private final String carName2 = "woni";
    private final String carNames = String.join(",", carName1, carName2);
    private List<String> carNameList;
    private CarResponseDto carResponseDto;

    @BeforeEach
    void setUp() {
        carNameList = Arrays.asList(carName1, carName2);
        carResponseDto = new CarResponseDto(carNameList);
    }

    @Test
    @DisplayName("CarResponse 생성자를 테스트 합니다.")
    void CarResponseDto_생성자_확인() {
        assertThat(carResponseDto).isNotNull();
        assertThat(carResponseDto.getCarNames()).isEqualTo(carNameList);
    }

    @Test
    @DisplayName("우승자 결과 변환을 테스트 합니다.")
    void 우승자_결과_변환() {
        assertThat(carResponseDto.getWinnerCarNames()).isEqualTo(carNames);
    }
}