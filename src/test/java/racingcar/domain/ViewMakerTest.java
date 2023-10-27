package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ViewMakerTest {

    @Test
    void 현재_위치_출력_테스트() {
        ViewMaker viewMaker = new ViewMaker();

        String expectA = "aaa : ---\n";
        String APositionView = viewMaker.makeCurrentPositionView("aaa", 3);

        String expectB = "b : \n";
        String BPositionVIew = viewMaker.makeCurrentPositionView("b", 0);

        Assertions.assertThat(expectA).isEqualTo(APositionView);
        Assertions.assertThat(expectB).isEqualTo(BPositionVIew);

    }

    @Test
    void 단일_승자_출력_테스트() {

        ViewMaker viewMaker = new ViewMaker();

        Car CarA = new Car("aaa");
        Car CarB = new Car("bbb");
        Car CarC = new Car("ccc");

        while (CarB.getForwardCount() == 0) {
            CarB.forward();
        }

        List<Car> carList = Arrays.asList(CarA, CarB, CarC);

        String winnerView = viewMaker.makeWinnerView(carList);
        String expect = "최종 우승자 : bbb";
        Assertions.assertThat(expect).isEqualTo(winnerView);
    }


    @Test
    void 다중_승자_테스트(){
        ViewMaker viewMaker = new ViewMaker();

        Car CarA = new Car("aaa");
        Car CarB = new Car("bbb");
        Car CarC = new Car("ccc");

        while (CarA.getForwardCount() == 0) {
            CarA.forward();
        }

        while (CarB.getForwardCount() == 0) {
            CarB.forward();
        }

        List<Car> carList = Arrays.asList(CarA, CarB, CarC);

        String winnerView = viewMaker.makeWinnerView(carList);
        String expect = "최종 우승자 : aaa, bbb";
        Assertions.assertThat(expect).isEqualTo(winnerView);

    }

}
