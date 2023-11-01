package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InputTest {

    @Test
    @DisplayName("Cars 객체가 잘 생성되는지 확인하는 테스트")
    public void testReadCars() {
        Input input = new Input();
        String inputString = "A,B,C";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        Cars cars = input.readCars();
        List<String> names = cars.getName();
        List<Integer> scores = cars.getScore();
        assertEquals(3 , names.size());
        assertEquals(3 , scores.size());
        assertThat(names).contains("A", "C");
        assertThat(names).containsExactly("A","B","C");
        assertEquals(Arrays.asList(0, 0, 0), scores);
    }
}