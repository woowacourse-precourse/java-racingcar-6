package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BasicControllerTest {
    @Test
    void BasicControllerTest(){
        BasicController controller = new BasicController("pobi,woni,jun", 5);
        Assertions.assertThat(controller.carList.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(controller.carList.get(1).getName()).isEqualTo("woni");
        Assertions.assertThat(controller.carList.get(2).getName()).isEqualTo("jun");


    }
}