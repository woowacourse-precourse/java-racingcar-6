package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.car.view.CarView;

public class CarTest {
    private final CarView carView = new CarView();

    @AfterEach
    void closeConsole(){
        Console.close();
    }
    @Test
    void 차량_입력_시_구분자가_입력되지_않은_경우_예외_처리(){
        String input = "pobiwonijun";

        assertThatThrownBy(() ->
            carView.inputToCarList(input)
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 차량_입력_시_중복된_이름이_있는_경우_예외_처리(){
        String carNames = "pobi,woni,pobi";
        InputStream in = new ByteArrayInputStream(carNames.getBytes());
        System.setIn(in);
        assertThatThrownBy(carView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차량_입력_시_5글자_초과_이름이_있는_경우_예외_처리(){
        String carNames = "pobi,woni,pobi11";
        InputStream in = new ByteArrayInputStream(carNames.getBytes());
        System.setIn(in);
        assertThatThrownBy(carView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }



}
