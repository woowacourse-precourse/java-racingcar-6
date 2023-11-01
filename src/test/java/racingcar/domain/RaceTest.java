package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import domain.Car;
import domain.Race;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import racingcar.support.StubCarEngine;

public class RaceTest {

    @Test
    void moveEachCars는_각_자동차를_이동시켜야_한다() {
        // given
        final Car 첫번째_차 = BDDMockito.mock(Car.class);
        final Car 두번째_차 = BDDMockito.mock(Car.class);
        final Race 레이스 = new Race(List.of(첫번째_차, 두번째_차));

        // when
        레이스.moveEachCars();

        // then
        verify(첫번째_차).move();
        verify(두번째_차).move();
    }

    @Test
    void toStringEachCars는_각_자동차의_toString_결과를_반환한다() {
        // given
        final Car 첫번째_차 = BDDMockito.mock(Car.class);
        final Car 두번째_차 = BDDMockito.mock(Car.class);
        final Race 레이스 = new Race(List.of(첫번째_차, 두번째_차));

        final String 첫번째_차_정보 = "첫번째_차_정보";
        final String 두번째_차_정보 = "두번째_차_정보";
        given(첫번째_차.toString()).willReturn(첫번째_차_정보);
        given(두번째_차.toString()).willReturn(두번째_차_정보);

        // when
        final List<String> result = 레이스.toStringEachCars();

        // then
        assertThat(result).contains(첫번째_차_정보, 두번째_차_정보);
    }

    @Test
    void toWinnerString은_가장_멀리간_사람의_이름을_반환한다() {
        // given
        final String 첫번째_차_이름 = "첫번째차";
        final String 두번째_차_이름 = "두번째차";

        final Car 항상_전진하는_차 = new Car(첫번째_차_이름, new StubCarEngine(true));
        final Car 항상_멈추는_차 = new Car(두번째_차_이름, new StubCarEngine(false));
        final Race 레이스 = new Race(List.of(항상_전진하는_차, 항상_멈추는_차));

        // when
        레이스.moveEachCars();
        final String winner = 레이스.toWinnerString();

        // then
        assertThat(winner).contains(첫번째_차_이름);
    }

    @Test
    void toWinnerString은_우승자가_여러명이면_쉼표로_구분하며_모든_우승자의_이름을_포함한다() {
        // given
        final String 첫번째_차_이름 = "첫번째차";
        final String 두번째_차_이름 = "두번째차";

        final Car 첫번째_차 = new Car(첫번째_차_이름, new StubCarEngine(true));
        final Car 두번째_차 = new Car(두번째_차_이름, new StubCarEngine(true));
        final Race 레이스 = new Race(List.of(첫번째_차, 두번째_차));

        // when
        레이스.moveEachCars();
        final String winner = 레이스.toWinnerString();

        // then
        assertAll(() -> {
            assertThat(winner).contains(",");
            final List<String> splitStrings = Arrays.stream(winner.split(","))
                    .map(String::trim).toList();
            assertThat(splitStrings).contains(첫번째_차_이름, 두번째_차_이름);
        });
    }
}
