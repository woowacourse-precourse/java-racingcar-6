package racingcar.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    RacingCars racingCars = new RacingCars(new String[]{"pobi","hash","neo"});

    @Test
    void output_자동화_경기의_실행_결과가_잘_출력_되는지_확인(){
        assertThat(racingCars.toString()).isEqualTo("pobi : \nhash : \nneo : \n");
    }

}