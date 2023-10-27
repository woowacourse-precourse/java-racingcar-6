package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.CarRaceGame.saveName;

class CarRaceGameTest {

    @DisplayName("saveName 메서드 동작")
    @Test
    void saveNameTest(){
        //given
        String inputNames = "pobi,woni";
        //when
        String[] names = saveName(inputNames);
        //then
        assertThat(names).contains("woni", "pobi");
        assertThat(names).containsExactly("pobi", "woni");
    }


}