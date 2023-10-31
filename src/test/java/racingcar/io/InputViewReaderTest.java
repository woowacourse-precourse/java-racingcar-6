package racingcar.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewReaderTest {
	
	@DisplayName("입력값이 일치한지 확인한다.")
	@Test
    public void checkReadLine(){
		InputViewReader reader = new InputViewReader();
        InputStream readLine = setReadLine("입력값");
        System.setIn(readLine);
        
        String expect = "입력값";
        String actual = reader.readLine();

        assertEquals(expect, actual);
    }
 
	private static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}
