package study;

import org.junit.jupiter.api.Test;
import racingcar.entity.Racer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class EntityTest {

    @Test
    void Racer_싱글톤_인스턴스_테스트(){
        //given
        String racerName="test";
        int testRacerHashCode = Racer.getInstance("test").hashCode();

        //when
        Racer instance = Racer.getInstance(racerName);

        //then
        assertThat(instance.hashCode()).isEqualTo(testRacerHashCode);
    }
}
