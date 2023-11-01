package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCarService;

class CarListTest {
    private RandomUtil randomUtil;
    private RacingCarService service;

    @BeforeEach
    public void initializeService() {
        this.randomUtil = new RandomNumber();
        this.service = new RacingCarService(randomUtil);
    }

    @Test
    void CarList인스턴스_생성시_초기화된다() {
        //given
        String userInputCarNames = "a,b,c";

        //when
        CarList carList = new CarList(service.splitCarNames(userInputCarNames), randomUtil);

        //then
        assertThat(carList.showCarList()).isEqualTo("a : \nb : \nc : \n");
    }

    @Test
    void 초기화된_CarList의_MaxPosition은_0이다() {
        //given
        String userInputCarNames = "a,b,c";
        CarList carList = new CarList(service.splitCarNames(userInputCarNames), randomUtil);

        //when
        int maxPosition = carList.findMaxPosition();

        //then
        assertThat(maxPosition).isEqualTo(0);
    }
}