package racingcar.view.inputview;

import java.util.Map;

public interface InputView<K>{
    K input(Map<String, Object> model);
}
