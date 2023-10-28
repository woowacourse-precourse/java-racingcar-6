package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarStatusTest {
    @Test
    void 현재_차_등록(){
        CarStatusDto carStatusDto = new CarStatusDto();
        carStatusDto.enrollCar("포르쉐");
        carStatusDto.enrollCar("K3");
        carStatusDto.enrollCar("포르쉐");
        Assertions.assertThat(carStatusDto.findAll().size()).isEqualTo(2);
    }

    @Test
    void 자동차_한칸이동_테스트() {
        CarStatusDto carStatusDto = new CarStatusDto();
        carStatusDto.enrollCar("포르쉐");
        carStatusDto.enrollCar("K3");
        carStatusDto.increaseCarPosition("포르쉐");
        Assertions.assertThat(carStatusDto.findByNamePosition("포르쉐").get()).isEqualTo(1);
    }
}
