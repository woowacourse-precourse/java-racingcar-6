package racingcar.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public abstract class InputView<K>{
    public abstract K input(Map<String, Object> model);

    public void closeScanner(){
        Console.close();
    }
}
