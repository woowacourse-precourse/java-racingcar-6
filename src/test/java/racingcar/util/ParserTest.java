package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;

public class ParserTest {

    @Test
    @DisplayName("띄어쓰기가 없을 경우 그대로 파싱한다.")
    void should_ParseToCars_When_NoSpaces() {
        String input = "호날두,메시,펠레,마라도나";
        Cars cars = Parser.parseStringToCars(input);
        assertThat(cars).usingRecursiveComparison().isEqualTo(new Cars(List.of(
                new Car(new CarName("호날두"), new CarPosition(0)),
                new Car(new CarName("메시"), new CarPosition(0)),
                new Car(new CarName("펠레"), new CarPosition(0)),
                new Car(new CarName("마라도나"), new CarPosition(0))
        )));
    }

    @Test
    @DisplayName("단어의 시작과 끝에 띄어쓰기가 있을경우 없앤다음 파싱한다.")
    void should_ParseToCars_When_SpacesAtStartAndEnd() {
        String input = "   손흥민    ,        김민재,           이강인       ";
        Cars cars = Parser.parseStringToCars(input);
        assertThat(cars).usingRecursiveComparison().isEqualTo(new Cars(List.of(
                new Car(new CarName("손흥민"), new CarPosition(0)),
                new Car(new CarName("김민재"), new CarPosition(0)),
                new Car(new CarName("이강인"), new CarPosition(0))
        )));
    }

    @Test
    @DisplayName("단어의 사이에 띄어쓰기가 있을경우 그대로 파싱한다.")
    void should_ParseToCars_When_SpacesBetweenWords() {
        String input = "해리 케인,  벤 화이트   ,        마티스 텔     ";
        Cars cars = Parser.parseStringToCars(input);
        assertThat(cars).usingRecursiveComparison().isEqualTo(new Cars(List.of(
                new Car(new CarName("해리 케인"), new CarPosition(0)),
                new Car(new CarName("벤 화이트"), new CarPosition(0)),
                new Car(new CarName("마티스 텔"), new CarPosition(0))
        )));
    }

    @Test
    @DisplayName("input의 마지막이 쉼표로 끝날경우 없앤다음 파싱한다.")
    void should_ParseToCars_When_EndsWithComma() {
        String input = "홀란드, 벨링엄, 음바페,";
        Cars cars = Parser.parseStringToCars(input);
        assertThat(cars).usingRecursiveComparison().isEqualTo(new Cars(List.of(
                new Car(new CarName("홀란드"), new CarPosition(0)),
                new Car(new CarName("벨링엄"), new CarPosition(0)),
                new Car(new CarName("음바페"), new CarPosition(0))
        )));
    }


}
