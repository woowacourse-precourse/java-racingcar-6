package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputSetting {
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream standardOut; // 표준 스트림을 저장할 멤버변수
    public void systemOut(){
        standardOut = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    public String getOutput(){
        return byteArrayOutputStream.toString();
    }

    public void printResult(){
        System.setOut(standardOut);
        System.out.println(getOutput());
    }
}
