package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller.RaceController;

public class RaceProgressTest extends NsTest {

    private CarList carList;
    private RaceController controller;

    @BeforeEach
    public void setUp() {
        carList = new CarList(new String[]{"aa", "bb", "cc", "dd", "ee"});
        controller = new RaceController(carList);
    }

    @DisplayName("시도횟수만큼 자동차들 전진 ")
    @Test
    void 시도_횟수_만큼_자동차들_전진() {
        controller.race(5);
        String console = output();

        long countaa = console.split("aa :").length - 1;// "aa :" 5번 등장 -> 5번의 전진을 시도
        long countbb = console.split("bb :").length - 1;// "bb :" 5번 등장 -> 5번의 전진을 시도
        long countcc = console.split("cc :").length - 1;// "cc :" 5번 등장 -> 5번의 전진을 시도
        long countdd = console.split("dd :").length - 1;// "dd :" 5번 등장 -> 5번의 전진을 시도
        long countee = console.split("ee :").length - 1;// "ee :" 5번 등장 -> 5번의 전진을 시도

        assertThat(countaa).isEqualTo(5);
        assertThat(countbb).isEqualTo(5);
        assertThat(countcc).isEqualTo(5);
        assertThat(countdd).isEqualTo(5);
        assertThat(countee).isEqualTo(5);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
