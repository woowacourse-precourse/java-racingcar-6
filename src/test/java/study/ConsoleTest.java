package study;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class ConsoleTest extends NsTest {
    @Test
    public void closeConsoleWhenScannerIsNull() {
        Console.close();
        Console.close();
    }
    @Test
    public void readCloseReadTest() {
       run("apple","new");
        assertThat(output()).contains("apple","java.util.NoSuchElementException: No line found");
    }
    public void consoleReadCloseReadHandle(){
        String input = Console.readLine();
        System.out.println(input);
        Console.close();
        try{
            input = Console.readLine(); // system.in 가 이미 닫혀 있어 에러가 발생한다.
        }
        catch (NoSuchElementException e){
            System.out.println(e);
        }
    }

    @Override
    protected void runMain() {
        consoleReadCloseReadHandle();
    }
}
