package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Ref;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacerTest{
    private Racer racer;

    @BeforeEach
    void setUp(){
        racer = new Racer("pobi", 3);
    }

    @Test
    void printDistance_출력_값_확인() {

        assertThat(racer.printDistance()).isEqualTo("pobi : ---");
    }

    @Test
    void getDistance_Random_값이_4보다_클_때(){
        racer.moveForward(5);

        assertThat(racer.getDistance()).isEqualTo(4);
    }

    @Test
    void getDistance_Random_값이_4보다_작을_때(){
        racer.moveForward(2);

        assertThat(racer.getDistance()).isEqualTo(3);
    }
}