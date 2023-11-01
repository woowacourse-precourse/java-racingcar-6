package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarListPutInMap;

public class ExceptionTest {
    @Test
    @DisplayName("중복된 이름은 예외 처리 되는가?")
    void 중복된_이름은_예외_처리_되는가() {
        CarListPutInMap carListPutInMap = new CarListPutInMap();
        List<String> carList = new ArrayList<>(Arrays.asList("qwer", "asdf", "qwer"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carListPutInMap.carListPutInMap(carList);
        });
    }

    @Test
    @DisplayName("다섯 자 이상인 이름은 예외 처리 되는가?")
    void 다섯_자_이상인_이름은_예외_처리_되는가() {
        CarListPutInMap carListPutInMap = new CarListPutInMap();
        List<String> carList = new ArrayList<>(Arrays.asList("qwer12", "asdf", "zxcv"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carListPutInMap.carListPutInMap(carList);
        });
    }
}
