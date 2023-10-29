package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.MessageConst.WINNER_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

class CarServiceTest {

    @Test
    @DisplayName("전진 기능 테스트")
    void forward() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        CarService carService = new CarService();
        CarRepository carRepository = new CarRepository();

        // when
        carRepository.save(pobi);
        carRepository.save(woni);
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(4,9);
            carService.updateCarScore(car, randomNum);
        }
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0,3);
            carService.updateCarScore(car, randomNum);
        }

        // then
        assertThat(pobi.getScore()).isEqualTo(1);
        assertThat(woni.getScore()).isEqualTo(1);
    }

    @Test
    @DisplayName("최종 우승자 생성 시 정해진 출력값 형식과 다르면 오류 발생")
    void createWinnerTest() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService();

        // when
        pobi.updateScore();
        pobi.updateScore();
        jun.updateScore();
        jun.updateScore();
        carRepository.save(pobi);
        carRepository.save(woni);
        carRepository.save(jun);

        List<Car> cars = carRepository.getCars();
        int highestScore = carService.findHighestScore(cars);
        List<Car> carsWithHighestScore = carService.createCarsWithHighestScore(cars, highestScore);
        StringBuilder winner = new StringBuilder();
        winner.append(WINNER_MESSAGE).append(" : ");
        for (Car car : carsWithHighestScore) {
            winner.append(car.createWinner());
        }
        winner = carService.formatOutput(winner);

        // then
        assertThat(winner.toString()).isEqualTo("최종 우승자 : pobi, jun");
    }
}