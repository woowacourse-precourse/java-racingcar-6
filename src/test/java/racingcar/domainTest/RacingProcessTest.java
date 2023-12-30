package racingcar.domainTest;


import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Racingprocess;


public class RacingProcessTest {

    @Test
    void 자동차목록과_진행상황을받아서_출력하는_기능_검사() {
        Racingprocess race = new Racingprocess();

        ArrayList<String> cars = new ArrayList<>(Arrays.asList("pobi","minju","woni"));
        ArrayList<Integer> progress= new ArrayList<>(Arrays.asList(1,2,0));
        String[] results = new String[cars.size()];
        for(int i=0; i<cars.size(); i++){
            results[i] = race.makingStatusBar(cars, progress, i);
        }

        assertThat(results[0]).contains("pobi : -");
        assertThat(results[1]).contains("minju : --");
        assertThat(results[2]).contains("woni : ");
    }


}
