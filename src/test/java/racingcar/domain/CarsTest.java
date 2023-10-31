package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import generator.NumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("공백을 입력할 경우 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_InputIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(List.of(
                    new Car(new CarName(""), new CarPosition(0))
            ));
        });
    }

    @Test
    @DisplayName("자동차를 한 대만 입력할 경우 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_NoCompetitor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(List.of(
                    new Car(new CarName("엄준식"), new CarPosition(0))
            ));
        });
    }

    @Test
    @DisplayName("쉼표만 입력할 경우 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_OnlyCommas() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(List.of(
                    new Car(new CarName(",,,,,,,,,,,,,,,,,"), new CarPosition(0))
            ));
        });
    }

    @Test
    @DisplayName("5가 나올경우 이동한다.")
    void should_Move_When_RandomNumberIs5() {
        NumberGenerator generator = new NumberGenerator(5);
        Cars cars = new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(5)),
                new Car(new CarName("식빵맨"), new CarPosition(3)),
                new Car(new CarName("카레빵맨"), new CarPosition(4))
        ));

        Cars carsAfterRound = cars.simulateNextRound(generator);

        assertThat(carsAfterRound).usingRecursiveComparison().isEqualTo(new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(6)),
                new Car(new CarName("식빵맨"), new CarPosition(4)),
                new Car(new CarName("카레빵맨"), new CarPosition(5))
        )));
    }

    @Test
    @DisplayName("3이 나올경우 이동하지 않는다.")
    void should_NotMove_When_RandomNumberIs3() {
        NumberGenerator generator = new NumberGenerator(3);
        Cars cars = new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(5)),
                new Car(new CarName("식빵맨"), new CarPosition(3)),
                new Car(new CarName("카레빵맨"), new CarPosition(4))
        ));

        Cars carsAfterRound = cars.simulateNextRound(generator);

        assertThat(carsAfterRound).usingRecursiveComparison().isEqualTo(new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(5)),
                new Car(new CarName("식빵맨"), new CarPosition(3)),
                new Car(new CarName("카레빵맨"), new CarPosition(4))
        )));
    }

    @Test
    @DisplayName("우승자가 한명일 경우 한명이 담긴 리스트를 반환한다.")
    void should_GetList_When_WinnerIsSingle() {
        Cars cars = new Cars(List.of(
                new Car(new CarName("피카츄"), new CarPosition(24)),
                new Car(new CarName("꼬부기"), new CarPosition(41)),
                new Car(new CarName("파이리"), new CarPosition(37))
        ));

        List<String> winner = cars.getWinners();
        assertThat(winner.get(0)).isEqualTo("꼬부기");
    }

    @Test
    @DisplayName("우승자가 여러명일 경우 여러명이 담긴 리스트를 반환한다.")
    void should_GetList_When_WinnerIsNotSingle() {
        Cars cars = new Cars(List.of(
                new Car(new CarName("피카츄"), new CarPosition(44)),
                new Car(new CarName("꼬부기"), new CarPosition(32)),
                new Car(new CarName("파이리"), new CarPosition(44))
        ));

        List<String> winner = cars.getWinners();
        assertThat(winner.get(0)).isEqualTo("피카츄");
        assertThat(winner.get(1)).isEqualTo("파이리");
    }

    @Test
    @DisplayName("중복된 자동차의 이름이 있을 경우 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_HasDuplicatedNames() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(List.of(
                    new Car(new CarName("피카츄"), new CarPosition(4)),
                    new Car(new CarName("꼬부기"), new CarPosition(5)),
                    new Car(new CarName("피카츄"), new CarPosition(6))
            ));
        });
    }
}
