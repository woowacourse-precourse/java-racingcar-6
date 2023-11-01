package racingcar.View;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SystemIn {
    // 사용자 입력 테스트
    public void systemIn(String ... args){
        byte[] bytes = String.join("\n", args).getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
    }
}
