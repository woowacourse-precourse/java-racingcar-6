package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import generator.NumberGenerator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("불변컬렉션 여부를 확인한다.")
    void should_ThrowUnsupportedOperationException_When_Modified() {
        assertThrows(UnsupportedOperationException.class, () -> {
            Cars cars = new Cars(List.of(
                    new Car(new CarName("신지드"), new CarPosition(0)),
                    new Car(new CarName("케넨"), new CarPosition(0)),
                    new Car(new CarName("제라스"), new CarPosition(0))
            ));
            cars.getCars().add(new Car(new CarName("럭스"), new CarPosition(0)));
        });
    }

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
    @DisplayName("참여자가 1000명을 초과할 경우 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_TooManyParticipants() {
        List<Car> manyCars = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            manyCars.add(new Car(new CarName("C" + i), new CarPosition(0)));
        }
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(manyCars);
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
    void should_ReturnSingleWinnerList_When_WinnerIsSingle() {
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
    void should_ReturnMultipleWinnerList_When_WinnersAreMultiple() {
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

    @Test
    @DisplayName("아무도 전진하지 못한 경우 무승부로 판정한다.")
    void should_JudgeTie_When_NoOneMoved() {
        Cars cars = new Cars(List.of(
                new Car(new CarName("베이가"), new CarPosition(0)),
                new Car(new CarName("아트록스"), new CarPosition(0)),
                new Car(new CarName("케넨"), new CarPosition(0))
        ));
        assertThat(cars.isTie()).isTrue();
    }

    @Test
    @DisplayName("한명 혹은 여럿이 우승한 경우 무승부로 판정하지 않는다.")
    void should_NotJudgeTie_When_WinnerExists() {
        Cars cars = new Cars(List.of(
                new Car(new CarName("베인"), new CarPosition(3)),
                new Car(new CarName("루시안"), new CarPosition(0)),
                new Car(new CarName("애쉬"), new CarPosition(3))
        ));
        assertThat(cars.isTie()).isFalse();
    }

    @Test
    @DisplayName("전부 전진했으며 나아간 거리가 같은 경우 무승부로 판정하지 않는다.")
    void should_NotJudgeTie_When_EveryoneMoved() {
        Cars cars = new Cars(List.of(
                new Car(new CarName("니달리"), new CarPosition(1)),
                new Car(new CarName("가렌"), new CarPosition(1)),
                new Car(new CarName("다리우스"), new CarPosition(1))
        ));
        assertThat(cars.isTie()).isFalse();
    }

}
