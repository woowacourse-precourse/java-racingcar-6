package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputSetting {
    protected void systemIn(String ... args){
        byte[] bytes = String.join("\n", args).getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
    }
}
