package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputSetting {
    // 사용자 입력 테스트
    protected void systemIn(String ... args){
        byte[] bytes = String.join("\n", args).getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
    }
}
