package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

class InputViewTest {
    private InputViewValidator inputViewValidator;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputViewValidator = new InputViewValidator();
        inputView = new InputView(inputViewValidator);
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in);
    }

    @Test
    void 차의_이름을_입력받고_배열로_변환한다(){
        List<String> expectedOutput = Arrays.asList("포비","워니","준");

        String string = "포비,워니,준";
        injectSystemIn(string);
        List<String> output = inputView.inputCarNames();
        Assertions.assertEquals(expectedOutput,output);
    }

//    @Test
//    void 총_라운드_수를_입력받고_정수로_변환한다(){
//        Integer expectedOutput = 5;
//
//        String string = "5";
//        injectSystemIn(string);
//        Integer output = inputView.inputTotalRoundNumber();
//        Assertions.assertEquals(expectedOutput,output);
//    }

    private void injectSystemIn(String userInput){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
    }

    private String captureSystemOut(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            runnable.run();
            return new String(outputStream.toByteArray(), Charset.defaultCharset());
        } finally {
            System.setOut(originalOut);
        }
    }
}
