package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.global.utils.generator.InputNamesGenerator;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientNamesTest {

    @Test
    public void testValidInput() {
        // given
        List<String> validNames = Arrays.asList("Alice", "Bob", "Char");

        // when
        ClientNames clientNames = new ClientNames(validNames);

        // then
        List<String> result = clientNames.getNames();
        assertEquals(validNames, result);

        Integer expectedCount = validNames.size();
        Integer resultCount = clientNames.getNameCount();
        assertEquals(expectedCount, resultCount);
    }

    @Test
    public void testInvalidNames() {
        // given
        List<String> invalidNames = Arrays.asList("Alice", "Bob", "ThisNa");
//        ClientNames clientNames = new ClientNames(invalidNames);

        // when and then
        assertThrows(IllegalArgumentException.class, () -> {
            ClientNames clientNames = new ClientNames(invalidNames);
        });
    }
}
