package testcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RaceNumber;

public class RaceNumberTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    public void CreateNumber() {
        final RaceNumber raceNumber = new RaceNumber();
        final List<String> members = new ArrayList<>(Arrays.asList("jack", "bob", "cars"));
        raceNumber.createRaceNumber(members);
        int[] number = raceNumber.getRaceNumber();
        for (int i : number) {
            assertTrue(number[i] == 1 || number[i] == 0);
        }
    }
}
