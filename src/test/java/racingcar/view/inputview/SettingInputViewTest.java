package racingcar.view.inputview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SettingInputViewTest {
    private static final Map<String, List<String>> INPUT_EXCEPTION_TEST = Map.ofEntries(
            Map.entry("carNames", List.of(",", ",,", ",가", "가,", ",가,", "가,,", "가,나,", " , ")),
            Map.entry("gameCount", List.of("-1", "가", "", " ", ".가", "-3", "1-1", "111111.111111", "11111-1111")));

    private final Map<String, String> model = new HashMap<>();
    private final InputView inputView = new SettingInputView();

    private static void input(String target) {
        InputStream input = new ByteArrayInputStream(target.getBytes());
        System.setIn(input);
    }

    @Test
    @DisplayName("입력에서 발생할 수 있는 예외들을 테스트한다.")
    void 차_번호_입력_예외_테스트() {
        //given
        model.put("carNames", null);
        int nameTestSize = INPUT_EXCEPTION_TEST.get("carNames").size();
        int countTestSize = INPUT_EXCEPTION_TEST.get("gameCount").size();
        List<String> inputs = new ArrayList<>();
        INPUT_EXCEPTION_TEST.values().forEach(inputs::addAll);
        input(String.join("\n", inputs));
        //when,then
        for (int i = 0; i < nameTestSize; i++) {
            model.put("cars", null);
            assertThrows(IllegalArgumentException.class, () -> {
                inputView.read(model);
            });
        }
        for (int i = 0; i < countTestSize; i++) {
            model.put("gameCount", null);
            assertThrows(IllegalArgumentException.class, () -> {
                inputView.read(model);
            });
        }
    }
}
