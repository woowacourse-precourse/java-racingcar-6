package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RaceManagerTest {

    static RaceEntry raceEntry = new RaceEntry(new ArrayList<>());
    static RaceManager raceManager = new RaceManager(raceEntry, 0);


    @Test
    void 단일_승자_생성_테스트() {

        List<Car> entryList = new ArrayList<>();
        Car CarA = new Car("aaa");
        Car CarB = new Car("bbb");
        Car CarC = new Car("ccc");

        CarA.forward();
        CarA.forward();
        CarA.forward();

        entryList.add(CarA);
        entryList.add(CarB);
        entryList.add(CarC);

        List<String> winner = raceManager.makeWinnerList(entryList);

        Assertions.assertThat(winner).contains("aaa");

    }

    @Test
    void 다중_승자_생성_테스트() {

        List<Car> entryList = new ArrayList<>();
        Car CarA = new Car("aaa");
        Car CarB = new Car("bbb");
        Car CarC = new Car("ccc");

        CarA.forward();
        CarB.forward();

        entryList.add(CarA);
        entryList.add(CarB);
        entryList.add(CarC);

        List<String> winner = raceManager.makeWinnerList(entryList);

        Assertions.assertThat(winner).contains("bbb", "aaa");

    }

}
