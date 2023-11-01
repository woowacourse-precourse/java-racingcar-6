package racingcar.domain.car.collection;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.wrapper.Name;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NamesTest {

    @Test
    void toString_정상_작동() {
        Names names = new Names(List.of(new Name("test1"), new Name("test2")));
        assertEquals(names.toString(), "test1,test2");
    }
}
