package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Ref;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacerTest{
    private Racer racer;

    @Test
    void Player가_제대로된_값을_출력하는지_확인() {

        racer = new Racer("pobi", 3);

        assertThat(racer.printDistance()).isEqualTo("pobi : ---");
    }

    @Test
    void 값에_따라_distance가_제대로_증가하는지_확인(){
        racer = new Racer("pobi", 3);
        racer.moveForward(5);

        assertThat(racer.getDistance()).isEqualTo(4);
    }

    @Test
    void 값이_작을경우_distance가_증가하는지_확인(){
        racer = new Racer("pobi", 3);
        racer.moveForward(2);

        assertThat(racer.getDistance()).isEqualTo(3);
    }
}