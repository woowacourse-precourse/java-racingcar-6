package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller.RaceController;
import racingcar.Model.Car;
import racingcar.View.ConsolePrint;

public class RaceProgressTest extends NsTest {

    private CarList carList;
    private RaceController controller;

    @BeforeEach
    public void setUp() {
        carList = new CarList(new String[]{"aa", "bb", "cc", "dd", "ee"});
        controller = new RaceController(carList);
    }

    void setDistance() {
        int index = 0;
        for (Car car : carList.getCarList()) {

            if (index == 0) {
                car.setDistance(3);//aa -> move forwward 3
            } else if (index == 1) {
                car.setDistance(5);//bb -> move forwward 5
            } else if (index == 2) {
                car.setDistance(5);//cc -> move forwward 5
            } else if (index == 3) {
                car.setDistance(4);//dd -> move forwward 4
            } else {
                car.setDistance(5);//ee -> move forwward 5
            }

            index++;
        }
    }

    String makeMoveStr(Car car) {
        int len = car.getDistance();
        String distance = car.getName() + " : ";
        for (int i = 0; i < len; i++) {
            distance += "-";
        }
        return distance; // ex ->  aa : ---
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

    @DisplayName("레이스 경주 결과 출력")
    @Test
    void 레이스_경주_결과_출력() {
        List<String> carsDistance = new ArrayList<>();
        setDistance();
        ConsolePrint.printRace(carList.getCarList());
        String console = output();

        for (Car car : carList.getCarList()) {
            carsDistance.add(makeMoveStr(car));
        }

        for (String distance : carsDistance) {
            assertThat(console).contains(distance);
        }
    }
    

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
