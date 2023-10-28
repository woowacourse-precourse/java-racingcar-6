package game;

import org.junit.jupiter.api.Test;
import racingcar.GameInputHandler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputTest {
    @Test
    void output_실행_시_자동차_이름_입력_메시지_출력(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        PrintStream originalOut = System.out;

        try{
            System.setOut(printStream);

            GameInputHandler gameInputHandler = new GameInputHandler();
            gameInputHandler.startGame();

            String printedMessage = outputStream.toString();

            assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", printedMessage.trim());
        } finally {
            System.setOut(originalOut);
        }
    }
}
