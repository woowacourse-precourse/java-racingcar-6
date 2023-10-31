package racingcar.utils;

import org.junit.jupiter.api.Test;

class InputManagerTest {
    InputValidator inputManager = new InputValidator();

    @Test
    public void 너무_긴_이름() {
       //given
        String name = "이이름은다섯글자가넘어,";

        //when
        inputManager.cars(name);

        //then

    }




}