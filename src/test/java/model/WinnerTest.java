package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WinnerTest {

    @Test
    public void 최대_전진_거리_반환() {
        String input = "pobi,jun,woni";
        Cars cars = new Cars(input);
        cars.getCars().get(0).tryMove(4);
        cars.getCars().get(1).tryMove(1);
        cars.getCars().get(2).tryMove(9);

        Winners winners = cars.getWinners();
        assertThat(winners.getMaxPlace()).isEqualTo(1);
    }

    @Test
    public void 최종_우승자가_여러명인지_확인() {
        Cars cars = new Cars("pobi,jun,woni");

        cars.getCars().get(0).tryMove(1);
        cars.getCars().get(1).tryMove(7);
        cars.getCars().get(2).tryMove(5);

        Winners winners = cars.getWinners();
        assertThat(winners.isMultiple()).isTrue();
    }

    @Test
    public void 최종_우승자들_반환() {
        String input = "pobi,jun,woni";
        Cars cars = new Cars(input);
        cars.getCars().get(0).tryMove(4);
        cars.getCars().get(1).tryMove(1);
        cars.getCars().get(2).tryMove(2);
        Winners winners = cars.getWinners();
        assertThat(winners.getCarNames()).isEqualTo(1);
    }

}

