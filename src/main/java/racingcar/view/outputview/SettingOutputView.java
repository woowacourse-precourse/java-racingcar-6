package racingcar.view.outputview;

import java.util.Map;

import static java.lang.System.out;

public class SettingOutputView implements OutputView {
    private final Map<String, Runnable> methodMap = Map.ofEntries(
            Map.entry("cars", printCarNamesText()),
            Map.entry("gameCount", printGameCount())
    );

    @Override
    public void display(Map<String, Object> displayEntities) {
        displayEntities.keySet().forEach(name -> runMethodByName(displayEntities, name));
    }

    private void runMethodByName(Map<String, Object> readEntities, String name) {
        if (!methodMap.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        if (readEntities.get(name) == null) {
            methodMap.get(name).run();
        }
    }

    private Runnable printCarNamesText() {
        return () -> out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private Runnable printGameCount() {
        return () -> out.println("시도할 회수는 몇회인가요?");
    }
}
