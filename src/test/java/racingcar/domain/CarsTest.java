package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.FixNumberGenerator;
import racingcar.utils.NumberGenerator;


public class CarsTest {
    Car pobi = new Car("pobi");
    Car woni = new Car("woni");
    Car jun = new Car("jun");
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 자동차가_잘움직이는지() {
        //given
        final NumberGenerator numberGenerator = new FixNumberGenerator();
        //when
        pobi.move(numberGenerator);
        pobi.move(numberGenerator);
        //then
        assertThat(pobi).extracting("position").isEqualTo(2);
    }
    
    @Test
    void 라운드_결과가_잘출력되는지() {
        //given
        final NumberGenerator numberGenerator = new FixNumberGenerator();
        Cars cars = new Cars(List.of(pobi, woni, jun));
        //when
        pobi.move(numberGenerator);
        woni.move(numberGenerator);
        jun.move(numberGenerator);
        cars.getRoundResult();
        //then
        assertThat(output.toString().trim()).isEqualTo("pobi : -\nwoni : -\njun : -");
    }

    @Test
    void 우승자를_잘출력하는지() {
        //given
        final NumberGenerator numberGenerator = new FixNumberGenerator();
        Cars cars = new Cars(List.of(pobi, woni, jun));
        //when
        pobi.move(numberGenerator);
        pobi.move(numberGenerator);
        woni.move(numberGenerator);
        jun.move(numberGenerator);
        cars.findWinners();
        //then
        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi");
    }

    @Test
    void 여러명의_우승자를_출력하는지() {
        //given
        final NumberGenerator numberGenerator = new FixNumberGenerator();
        Cars cars = new Cars(List.of(pobi, woni, jun));
        //when
        pobi.move(numberGenerator);
        woni.move(numberGenerator);
        jun.move(numberGenerator);
        cars.findWinners();
        //then
        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi, woni, jun");
    }

    @Test
    void 등록된_자동차가_없을_때_예외() {
        //given
        Cars cars = new Cars(List.of());
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> cars.findWinners());
        //then
        assertThat(e.getMessage()).isEqualTo("차량 리스트가 비었습니다.");
    }

}
