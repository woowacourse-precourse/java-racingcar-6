package util;

import model.CarStatusDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OutputTest {

    @Test
    void 숫자_입력메시지_출력() {
        OutputView outputView = new OutputView();
        Assertions.assertThat(outputView.numberInputMessage()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 자동차출력하기() {
        CarStatusDto carStatusDto = new CarStatusDto();
        carStatusDto.enrollCar("포르쉐");
        carStatusDto.enrollCar("K3");
        OutputView outputView = new OutputView();
        outputView.carStatus(carStatusDto.findAll());
    }

    @Test
    void 자동차_이동_출력() {
        CarStatusDto carStatusDto = new CarStatusDto();
        carStatusDto.enrollCar("포르쉐");
        carStatusDto.enrollCar("K3");
        carStatusDto.increaseCarPosition("포르쉐");
        carStatusDto.increaseCarPosition("포르쉐");
        carStatusDto.increaseCarPosition("K3");
        OutputView outputView = new OutputView();
        outputView.carStatus(carStatusDto.findAll());
    }





}


