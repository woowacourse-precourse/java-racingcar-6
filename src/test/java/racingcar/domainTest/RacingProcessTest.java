package racingcar.domainTest;


import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingProcess;
import racingcar.domain.Car;


public class RacingProcessTest {

    @Test
    void 자동차목록을_받아서_진행도를_출력하는_기능_검사() {
        RacingProcess race = new RacingProcess();
        ArrayList<Car> carList = new ArrayList<>();
        String[] names = {"pobi", "minju", "woni"};
        int[] progress = {1, 2, 0};
        for(int i=0; i<3; i++){
            carList.add(new Car(names[i], progress[i]));
        }
        String[] results = new String[carList.size()];
        for(int i=0; i<results.length; i++){
            results[i] = race.makingStatusBar(carList.get(i));
        }

        assertThat(results[0]).contains("pobi : -");
        assertThat(results[1]).contains("minju : --");
        assertThat(results[2]).contains("woni : ");
    }


}
