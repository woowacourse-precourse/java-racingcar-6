package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import racingcar.dto.PlayGameRequestDto;
import racingcar.dto.PlayGameResponseDto;
import racingcar.exception.UserCarNameInputException;
import racingcar.exception.UserTryNumberInputException;
import racingcar.service.ConsolePrintServiceImpl;
import racingcar.service.GameService;
class GameControllerTest extends NsTest {

    @Mock
    GameService gameService;

    @Spy
    ConsolePrintServiceImpl printService;

    @InjectMocks
    GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("게임 시작 후 끝나면 결과 출력")
    @Test
    void startGame_success() {
        PlayGameResponseDto playGameResponseDto = new PlayGameResponseDto(List.of("carA", "carC"));
        when(gameService.playGame(any(PlayGameRequestDto.class))).thenReturn(playGameResponseDto);
        run("carA,carB,carC", "5");
        gameController.startGame();

        assertThat(output()).contains("최종 우승자 : ");
    }

    @DisplayName("5글자 초과된 이름 입력")
    @Test
    void userCarNameInput_error() {
        run("pobi,javaji", "1");
        assertThatThrownBy(() -> gameController.startGame())
                .isInstanceOf(UserCarNameInputException.class);
    }

    @DisplayName("횟수에 문자 입력")
    @Test
    void userTryNumberInput_error() {
        run("pobi,javai", "asd");
        assertThatThrownBy(() -> gameController.startGame())
                .isInstanceOf(UserTryNumberInputException.class);
    }
    @Override
    protected void runMain() {

    }
}