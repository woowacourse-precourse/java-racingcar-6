package racingcar.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class GameResponseDtoTest {
    @Test
    @DisplayName("GameResponse 생성자를 테스트 합니다.")
    void GameResponse_생성자_확인() {
        Car car = Car.from("pobi");
        GameResponseDto gameResponseDto = new GameResponseDto(car);

        assertThat(gameResponseDto).isNotNull();
        assertThat(gameResponseDto.getCarName()).isEqualTo(car.getName());
    }

    @Test
    @DisplayName("출력 결과 변환을 테스트 합니다.")
    void 출력_결과_변환() {
        Car car = Car.from("pobi");
        car.move();
        GameResponseDto gameResponseDto = new GameResponseDto(car);
        String result = gameResponseDto.createMessage();

        assertThat(result).isEqualTo("pobi : -");
    }
}