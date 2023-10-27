package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car pobi;
    private Car woni;
    private Car jun;
    @BeforeEach
    void setUp() {
        pobi = new Car("pobi");
        woni = new Car("woni");
        jun = new Car("jun");
    }

    @Test
    void Car_출력_테스트() {
        //given
        //when
        pobi.move();
        pobi.move();
        woni.move();
        woni.move();
        woni.move();
        woni.move();
        jun.move();
        jun.move();
        jun.move();
        //then
        assertThat(pobi.toString()).isEqualTo("pobi : --");
        assertThat(woni.toString()).isEqualTo("woni : ----");
        assertThat(jun.toString()).isEqualTo("jun : ---");
    }
}