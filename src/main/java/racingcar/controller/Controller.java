package racingcar.controller;

import java.util.Map;

public interface Controller {
    void run(Map<String, String> parameter, Map<String, Object> model);
}
