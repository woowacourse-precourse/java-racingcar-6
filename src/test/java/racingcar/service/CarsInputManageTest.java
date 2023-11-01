package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import racingcar.domain.TotalCar;
import racingcar.view.InputView;

public class CarsInputManageTest {
    CarsInputManage manage = new CarsInputManage();
    InputView input = new InputView();

    @Test
    void 자동차_이름을_가지고_자동차_클래스_집합_만들기() {
        String names = "pobi,woo,teco";
        InputStream in = new ByteArrayInputStream(names.getBytes());
        System.setIn(in);

        assertThat(manage.makeCars(input)).isInstanceOf(TotalCar.class);
        Console.close();
    }
}
