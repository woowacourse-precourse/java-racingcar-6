package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.PlayGameRequestDto;
import racingcar.dto.PlayGameResponseDto;

class GameServiceTest {

    GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService(new ConsolePrintServiceImpl());
    }

    @DisplayName("우승자는 한 명 이상 있다")
    @Test
    void playGame(){
        PlayGameRequestDto playGameRequestDto = new PlayGameRequestDto(List.of("carA", "carB", "carC"), 5);
        PlayGameResponseDto playGameResponseDto = gameService.playGame(playGameRequestDto);

        Assertions.assertThat(playGameResponseDto.getWinnerList().size()).isGreaterThanOrEqualTo(1);
    }

}