package racingcar.domain.dto;

import org.junit.jupiter.api.Test;
import racingcar.domain.Name;
import racingcar.domain.Position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarResultTest {
    @Test
    void 자동차_레이스_1라운드_결과를_나타내는_carResult(){
        CarResult carResult = CarResult.of(new Name("pobi"), new Position(1));
        assertThat(carResult).isEqualTo(new CarResult(new Name("pobi"), new Position(1)));
    }

    @Test
    void CarResult의_toString을_실행하면_자동차_이름과_자동차_위치를_문자열로_반환한다(){
        CarResult carResult = CarResult.of(new Name("pobi"), new Position(1));
        assertThat(carResult.toString()).isEqualTo("pobi : -");
    }

    @Test
    void CarResult의_Position과_매개변수로_받은_자동차_위치가_같으면_true를_반환한다(){
        CarResult carResult = CarResult.of(new Name("pobi"), new Position(1));
        assertThat(carResult.isSamePosition(new Position(1))).isTrue();
    }
}