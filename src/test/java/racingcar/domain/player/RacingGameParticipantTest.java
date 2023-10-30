package racingcar.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fake.FakeGameConsoleUtil;
import racingcar.util.GameConsole;

class RacingGameParticipantTest {

        public static final int NAME_LIMIT_LENGTH = 5;

        @Test
        @DisplayName("성공: 자동차 이름을 규칙에 맞게 작성한 경우")
        void call_submitRacingCarNameList_will_return_String_List() {
                //given
                GameConsole gameConsole = new FakeGameConsoleUtil("carA,carB,carC");
                RacingPlayer player = new RacingGameParticipant(gameConsole);

                //when
                List<String> nameList = player.submitRacingCarNameList(NAME_LIMIT_LENGTH);

                //then
                assertThat(nameList.size()).isEqualTo(3);
                assertThat(nameList.get(0)).isEqualTo("carA");
                assertThat(nameList.get(1)).isEqualTo("carB");
                assertThat(nameList.get(2)).isEqualTo("carC");
        }

        @Test
        @DisplayName("실패: 자동차 이름이 5자 초과인 경우")
        void call_submitRacingCarNameList_will_throw_IllegalArgumentException() {
                //given
                GameConsole gameConsole = new FakeGameConsoleUtil("longCarName,carB,carC");
                RacingPlayer player = new RacingGameParticipant(gameConsole);

                //when
                Assertions.assertThatThrownBy(() -> player.submitRacingCarNameList(NAME_LIMIT_LENGTH))
                        .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("성공: 자동차 게임의 laps 를 반환")
        void call_submitLaps_will_return_BigInteger() {
                //given
                GameConsole gameConsole = new FakeGameConsoleUtil("5");
                RacingPlayer player = new RacingGameParticipant(gameConsole);

                //when
                BigInteger bigInteger = player.submitLaps();

                //then
                assertThat(bigInteger).isNotNull();
                assertThat(bigInteger.longValue()).isEqualTo(5L);
        }

        @Test
        @DisplayName("실패: 자동차 게임의 laps 를 음수로 입력한 경우")
        void call_submitLaps_will_return_IllegalArgumentException_by_negative_number() {
                //given
                GameConsole gameConsole = new FakeGameConsoleUtil("-5");
                RacingPlayer player = new RacingGameParticipant(gameConsole);

                //when
                Assertions.assertThatThrownBy(player::submitLaps)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양수만 입력할 수 있습니다.");
        }

        @Test
        @DisplayName("실패: 자동차 게임의 laps 를 숫자 이외의 문자로 입력한 경우 ")
        void call_submitLaps_will_return_IllegalArgumentException_by_not_only_digit() {
                //given
                GameConsole gameConsole = new FakeGameConsoleUtil("5A");
                RacingPlayer player = new RacingGameParticipant(gameConsole);

                //when
                Assertions.assertThatThrownBy(player::submitLaps)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양수만 입력할 수 있습니다.");
        }
}
