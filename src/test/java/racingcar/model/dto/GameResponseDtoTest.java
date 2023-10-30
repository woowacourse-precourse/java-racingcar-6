package racingcar.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class GameResponseDtoTest {
    private Car car;
    private GameResponseDto gameResponseDto;

    @BeforeEach
    void setUp() {
        car = Car.from("pobi");
        car.move();
        gameResponseDto = new GameResponseDto(car);
    }

    @Test
    @DisplayName("GameResponse 생성자를 테스트 합니다.")
    void GameResponseDto_생성자_확인() {
        assertThat(gameResponseDto).isNotNull();
        assertThat(gameResponseDto).extracting(GameResponseDto::getCarName).isEqualTo(car.getName());
    }

    @Test
    @DisplayName("출력 결과 변환을 테스트 합니다.")
    void 출력_결과_변환() {
        assertThat(gameResponseDto).extracting(GameResponseDto::getGameResult).isEqualTo("pobi : -");
    }
}