package racingcar.global.utils.generator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.global.utils.ConsoleUtil;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputNamesGeneratorTest {

    @Test
    public void testValidInput() {
        // given
        InputNamesGenerator inputNamesGenerator = new InputNamesGenerator();
        String input = "Alice,Bob,Char\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        List<String> result = inputNamesGenerator.nameGenerate();

        // then
        List<String> expected = Arrays.asList("Alice", "Bob", "Char");
        assertEquals(expected, result);
    }


//    @Test
//    public void testInvalidInput() {
//        // Arrange
//        InputNamesGenerator inputNamesGenerator = new InputNamesGenerator();
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> {
//            inputNamesGenerator.nameGenerate("Alice,Bob,Charlie,"); // Extra comma to trigger an exception
//        });
//    }

}