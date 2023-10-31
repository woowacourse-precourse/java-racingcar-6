package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinnerRepositoryTest {
    private CarsRepository carsRepo = new CarsRepository();
    private final WinnerRepository winnerRepo = new WinnerRepository();

    @Test
    void 우승자가_1명인_경우_출력() {
        String[] cars = {"a", "b", "c"};
        carsRepo.initCars(cars);
        int randomNum = 4;
        // a를 3전진 시킴
        carsRepo.plusNum(0, randomNum);
        carsRepo.plusNum(0, randomNum);
        carsRepo.plusNum(0, randomNum);

        //자동차 중 가장많이 간 횟수를 winnerRepo에 저장
        winnerRepo.saveNum(carsRepo.findMaxPosition());

        // 가장많이 간 횟수인 자동차를 모두 winnerRepo에 저장
        for (int i = 0; i < carsRepo.size(); i++) {
            if (winnerRepo.isWinner(carsRepo.getPosition(i))) {
                winnerRepo.add(carsRepo.getName(i));
            }
        }
        assertThat(winnerRepo.convertListToString()).isEqualTo("a");
    }

    @Test
    void 우승자가_여러명인_경우_출력() {
        String[] cars = {"a", "b", "c"};
        carsRepo.initCars(cars);
        int randomNum = 4;
        // a를 2전진 시킴
        carsRepo.plusNum(0, randomNum);
        carsRepo.plusNum(0, randomNum);

        // c도 2전진 시킴
        carsRepo.plusNum(2, randomNum);
        carsRepo.plusNum(2, randomNum);

        //자동차 중 가장많이 간 횟수를 winnerRepo에 저장
        winnerRepo.saveNum(carsRepo.findMaxPosition());

        // 가장많이 간 횟수인 자동차를 모두 winnerRepo에 저장
        for (int i = 0; i < carsRepo.size(); i++) {
            if (winnerRepo.isWinner(carsRepo.getPosition(i))) {
                winnerRepo.add(carsRepo.getName(i));
            }
        }
        assertThat(winnerRepo.convertListToString()).isEqualTo("a, c");
    }

}