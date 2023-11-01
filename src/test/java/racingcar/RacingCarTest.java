package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.groups.Tuple.tuple;

public class RacingCarTest {
    @Test
    void RacingCar_객체_생성() {
        List<RacingCar> result = new ArrayList<>();
        RacingCar racingCar1 = new RacingCar("junho", "");
        RacingCar racingCar2 = new RacingCar("bang", "");
        RacingCar racingCar3 = new RacingCar("kim", "");
        result.add(racingCar1);
        result.add(racingCar2);
        result.add(racingCar3);
        assertThat(result).filteredOn("count", 0).containsOnly(racingCar1, racingCar2, racingCar3);
        assertThat(result).extracting("name", "count")
                .contains(tuple("junho", 0));
    }

    @Test
    void 입력된값이없을경우_예외처리(){
        String userInput = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //NullPointerException Throw하는 작업을 작성
            List<String> userInputList = new ArrayList<>();
            if(userInput==""){
                throw new IllegalArgumentException("입력된 값이 없습니다. 어플리케이션을 종료합니다.");
            }
            for (String s : userInput.split(",")) {
                userInputList.add(s);
            }
        });
    }

}
