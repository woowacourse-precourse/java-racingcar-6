package racingcar.mvc.model;

import org.junit.jupiter.api.Test;
import racingcar.model.CarSetting;

import java.util.Iterator;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


class CarSettingTest {
    private CarSetting carSetting;
    private static String inputValue = "songHee, minGu";

    @Test
    public void string배열로_분리성공_확인() throws Exception{
        //given
        carSetting = new CarSetting();

        //when
        String[] strings = carSetting.getStrings(inputValue);

        //then
        assertThat(strings).contains("songHee", "minGu");
    }

    @Test
    void 경주_자동차_입력성공_확인(){
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