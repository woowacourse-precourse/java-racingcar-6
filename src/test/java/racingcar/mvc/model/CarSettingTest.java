package racingcar.mvc.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.CarSetting;

import java.util.Iterator;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


class CarSettingTest {
    private CarSetting carSetting;
    private static String inputValue = "songHee, minGu";
    @Test
    void 경주_자동차_이름_입력(){
        //given
        carSetting = new CarSetting(inputValue);

        //when
        Map<String, Integer> carsSituation = carSetting.getCarsSituation();

        //then
        Iterator<String> iterator = carsSituation.keySet().iterator();

        assertThat(carsSituation.size()).isEqualTo(2);
        assertThat(carsSituation.keySet()).contains("songHee", "minGu");
        assertThat(carsSituation.values()).contains(0, 0);
    }
}