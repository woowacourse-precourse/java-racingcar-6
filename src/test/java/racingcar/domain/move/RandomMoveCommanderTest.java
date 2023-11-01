package racingcar.domain.move;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import fixed.QueuedNumberPicker;
import java.util.List;
import number.NumberPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidMoveCommandNumberException;

final class RandomMoveCommanderTest {
    @DisplayName("MoveCommander는 0이상 4 미만의 숫자를 받으면 MoveCommand.STAY를 반환한다.")
    @Test
    void nextCommand_withZeroOrPositiveNumberLessThanFour_shouldReturnSTAY() {
        // given
        final NumberPicker numberPicker = new QueuedNumberPicker(List.of(0, 1, 2, 3));
        final MoveCommander moveCommander = new RandomMoveCommander(numberPicker);

        // when
        // then
        for (int i = 0; i < 4; i++) {
            final MoveCommand moveCommand = moveCommander.nextCommand();
            assertThat(moveCommand).isEqualTo(MoveCommand.STAY);
        }
    }

    @DisplayName("MoveCommander는 4 이상 9이하의 숫자를 받으면 MoveCommand.GO를 반환한다.")
    @Test
    void nextCommand_withNumberGreaterThanThreeOrLessThanTen_shouldReturnGo() {
        // given
        final NumberPicker numberPicker = new QueuedNumberPicker(List.of(4, 5, 6, 7, 8, 9));
        final MoveCommander moveCommander = new RandomMoveCommander(numberPicker);

        // when
        // then
        for (int i = 0; i < 6; i++) {
            final MoveCommand moveCommand = moveCommander.nextCommand();
            assertThat(moveCommand).isEqualTo(MoveCommand.GO);
        }
    }

    @DisplayName("MoveCommander는 0 미만 10이상의 숫자를 받으면 예외가 발생한다.")
    @Test
    void nextCommand_withNegativeNumberOrGreaterThanNine_shouldThrowException() {
        // given
        final NumberPicker numberPicker1 = new QueuedNumberPicker(List.of(-1, -2, -3, -4));
        final NumberPicker numberPicker2 = new QueuedNumberPicker(List.of(10, 11, 12, 13));
        final MoveCommander moveCommander1 = new RandomMoveCommander(numberPicker1);
        final MoveCommander moveCommander2 = new RandomMoveCommander(numberPicker2);

        // when
        // then
        for (int i = 0; i < 4; i++) {
            assertThatThrownBy(moveCommander1::nextCommand)
                    .isInstanceOf(InvalidMoveCommandNumberException.class)
                    .hasMessage(InvalidMoveCommandNumberException.INVALID_MOVE_COMMAND_NUMBER_EXCEPTION_MESSAGE);
        }

        for (int i = 0; i < 4; i++) {
            assertThatThrownBy(moveCommander2::nextCommand)
                    .isInstanceOf(InvalidMoveCommandNumberException.class)
                    .hasMessage(InvalidMoveCommandNumberException.INVALID_MOVE_COMMAND_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}