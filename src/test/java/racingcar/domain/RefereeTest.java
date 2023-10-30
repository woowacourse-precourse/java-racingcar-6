package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class RefereeTest{

    private MockedStatic<Randoms> randoms;
    private Referee referee;

    @BeforeEach
    void init(){
        randoms = mockStatic(Randoms.class);
        referee = new Referee();
    }

    @AfterEach
    void afterEach(){
        randoms.close();
    }

    @Test
    @DisplayName("심판이 주어진 레이싱 카 목록 중 우승자를 찾아낸다.")
    void 심판_우승자_목록_판별(){
        //given
        Cars cars = new Cars(List.of("Pobi", "woni", "jun"));
        carGoForward(cars.getCarList().get(0));
        carGoForward(cars.getCarList().get(1));
        carGoForward(cars.getCarList().get(1));

        //when
        List<String> carNames = referee.determineWinners(cars);

        //then
        assertThat(carNames).hasSize(1).contains("woni");

    }

    private void carGoForward(Car car){
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(4);
        car.drive();
    }

}
