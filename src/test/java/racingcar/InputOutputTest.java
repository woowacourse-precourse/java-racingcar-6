package racingcar;

import java.io.ByteArrayInputStream;

public class InputOutputTest {

    // 콘솔 입력창에 임의로 지정하기 위한 함수
    // input의 바이트배열을 스트림에 담아 System.in에 할당
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}