package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

class WinnerRepositoryTest {
    private final Cars cars = Cars.create();
    private final WinnerRepository winnerRepo = new WinnerRepository();

    @Test
    void 우승자가_1명인_경우_출력() {
        String[] carArr = {"a", "b", "c"};
        cars.init(carArr);
        int randomNum = 4;
        // a를 3전진 시킴
        cars.plusNum(0, randomNum);
        cars.plusNum(0, randomNum);
        cars.plusNum(0, randomNum);

        //자동차 중 가장많이 간 횟수를 winnerRepo에 저장
        winnerRepo.saveNum(cars.findMaxPosition());

        // 가장많이 간 횟수인 자동차를 모두 winnerRepo에 저장
        for (int i = 0; i < cars.size(); i++) {
            if (winnerRepo.isWinner(cars.getPosition(i))) {
                winnerRepo.add(cars.getName(i));
            }
        }
        assertThat(winnerRepo.convertListToString()).isEqualTo("a");
    }

    @Test
    void 우승자가_여러명인_경우_출력() {
        String[] carArr = {"a", "b", "c"};
        cars.init(carArr);
        int randomNum = 4;
        // a를 2전진 시킴
        cars.plusNum(0, randomNum);
        cars.plusNum(0, randomNum);

        // c도 2전진 시킴
        cars.plusNum(2, randomNum);
        cars.plusNum(2, randomNum);

        //자동차 중 가장많이 간 횟수를 winnerRepo에 저장
        winnerRepo.saveNum(cars.findMaxPosition());

        // 가장많이 간 횟수인 자동차를 모두 winnerRepo에 저장
        for (int i = 0; i < cars.size(); i++) {
            if (winnerRepo.isWinner(cars.getPosition(i))) {
                winnerRepo.add(cars.getName(i));
            }
        }
        assertThat(winnerRepo.convertListToString()).isEqualTo("a, c");
    }

}