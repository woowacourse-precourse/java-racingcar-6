package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameCountTest {
    GameCount gameCount = new GameCount();
    Cars cars = new Cars();
    List<String> list = new ArrayList<>();

    @BeforeEach
    void before() {
        for (String key : "a,b,c".split(",")) list.add(key);
        cars.setCarsData(list);
    }

    @AfterEach
    void after() {
        cars.getCarsData().clear();
        list.clear();
        gameCount.setGameCount(0);
    }

    @Test
    void setGameCount() {
        int returnValue = gameCount.setGameCount(1);
        assertThat(returnValue).isSameAs(1);
    }

    @Test
    void getGameCount() {
        int getNumber = gameCount.getGameCount();
        assertThat(gameCount.getGameCount()).isEqualTo(0);

        int setNumber = gameCount.setGameCount(getNumber);
        assertThat(setNumber).isSameAs(getNumber);
    }

    @Test
    void setHighStep() {
        gameCount.setHighStep();
        System.out.println("gameCount.getHighStep() = " + gameCount.getHighStep());
        assertThat(gameCount.getHighStep()).isSameAs(0);
    }

    @Test
    void getHighStep() {
        int highStep = gameCount.getHighStep();
        Collection<Integer> values = cars.getCarsData().values();
        assertThat(values).contains(highStep);
    }
}