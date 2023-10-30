package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class CarsTest{

    MockedStatic<Randoms> randoms;

    @BeforeEach
    void init(){
        randoms = mockStatic(Randoms.class);
    }

    @AfterEach
    void afterEach(){
        randoms.close();
    }

    @Test
    @DisplayName("입력받은 문자열을 쉼표 기준으로 구분하여 자동차 목록을 반환한다.")
    void 입력받은_문자열을_쉼표_기준으로_구분하여_자동차_목록_반환(){
        //given
        String input = "pobi,woni,jun";
        int initialForwardCount = 0;
        String name1 = "pobi";
        String name2 = "woni";
        String name3 = "jun";

        //when
        Cars cars = new Cars(Arrays.asList(input.split(",")));

        //then
        assertThat(cars.getCarList()).hasSize(3)
                .extracting(Car::getName, Car::getForwardCount)
                .contains(
                        tuple(
                                name1, initialForwardCount
                        ),
                        tuple(
                                name2, initialForwardCount
                        ),
                        tuple(
                                name3, initialForwardCount
                        )
                );

    }

    @Test
    @DisplayName("차 목록에서 전진 횟수가 가장 많은 차 이름의 목록을 반환한다(all).")
    void 최대_전진_차_이름_목록_반환_all(){
        //given
        Cars cars = new Cars(List.of("Pobi", "woni", "jun"));

        //when
        List<String> carNames = cars.getMaxForwardCountCarNames();

        //then
        assertThat(carNames).hasSize(3).contains("Pobi", "woni", "jun");

    }

    @Test
    @DisplayName("차 목록에서 전진 횟수가 가장 많은 차 이름의 목록을 반환한다(2명).")
    void 최대_전진_차_이름_목록_반환_2명(){
        //given
        Cars cars = new Cars(List.of("Pobi", "woni", "jun"));
        carGoForward(cars.getCarList().get(2));
        carGoForward(cars.getCarList().get(2));
        carGoForward(cars.getCarList().get(1));
        carGoForward(cars.getCarList().get(1));

        //when
        List<String> carNames = cars.getMaxForwardCountCarNames();

        //then
        assertThat(carNames).hasSize(2).contains("woni", "jun");

    }

    @Test
    @DisplayName("차 목록에서 전진 횟수가 가장 많은 차 이름의 목록을 반환한다(1명).")
    void 최대_전진_차_이름_목록_반환_1명(){
        //given
        Cars cars = new Cars(List.of("Pobi", "woni", "jun"));
        carGoForward(cars.getCarList().get(0));
        carGoForward(cars.getCarList().get(1));
        carGoForward(cars.getCarList().get(1));

        //when
        List<String> carNames = cars.getMaxForwardCountCarNames();
        System.out.println("@@" + carNames.get(0));

        //then
        assertThat(carNames).hasSize(1).contains("woni");

    }

    private void carGoForward(Car car){
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(4);
        car.drive();
    }

}
