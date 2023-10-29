package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @DisplayName("자동차 이름 예외 처리 확인")
    @Test
    void 자동차_이름_예외_처리_확인() {

        Game game = new Game();
        String[] carName = {"가,가", "가,,가", "가,다,", "가나다라마", "가나다라마바사, 아자", "간ㄴ, 아자"};

        for (String name : carName) {
            assertThrows(IllegalArgumentException.class, () -> {
                game.setCar(name);
            });
        }

    }


    @DisplayName("게임 횟수 유효성 체크 확인")
    @Test
    void 게임_횟수_예외_처리_확인() {
        String[] finalRaceCount = {"-34234", "12312312312311", "2147483648", "한글", "English", "123"};
        Game game = new Game();

        for (String count : finalRaceCount) {
            assertThrows(IllegalArgumentException.class, () -> {
                game.setFinalRaceCount(count);
            });
        }
    }
}