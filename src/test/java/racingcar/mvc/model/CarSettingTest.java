package racingcar.mvc.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.model.CarSetting;


class CarSettingTest {
    private CarSetting carSetting;
    private static String INPUT_VALUE = "songHee, minGu";

    @Test
    public void string배열로_분리성공_확인() throws Exception {
        //given
        carSetting = new CarSetting();

        //when
        String[] strings = carSetting.getStrings(INPUT_VALUE);

        //then
        assertThat(strings).contains("songHee", "minGu");
    }

    @Test
    public void string배열에서_Map값으로_입력성공_확인() throws Exception {
        //given
        carSetting = new CarSetting();
        String[] strings = carSetting.getStrings(INPUT_VALUE);

        //when
        carSetting.setCarStringArrayToMap(strings);
        Map<String, Integer> expectedMap = new HashMap<>();
        for (String user : strings) {
            expectedMap.put(user, 0);
        }

        //then
        assertThat(carSetting.getCarsSituation().size()).isEqualTo(2);
        assertThat(carSetting.getCarsSituation()).containsAllEntriesOf(expectedMap);
    }

    @Test
    public void 경주_자동차_입력성공_확인() {
        //given
        carSetting = new CarSetting(INPUT_VALUE);

        //when
        Map<String, Integer> carsSituation = carSetting.getCarsSituation();

        //then
        Iterator<String> iterator = carsSituation.keySet().iterator();

        assertThat(carsSituation.size()).isEqualTo(2);
        assertThat(carsSituation.keySet()).contains("songHee", "minGu");
        assertThat(carsSituation.values()).contains(0, 0);
    }

    @Test
    public void 최종_우승자_일치성공_확인() throws Exception {
        //given

        //when

        //then

    }


}
