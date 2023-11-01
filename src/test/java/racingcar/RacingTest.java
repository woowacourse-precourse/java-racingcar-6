package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.respository.RacingRepository;
import racingcar.service.RacingService;
import racingcar.service.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingTest {

    private RacingRepository racingRepository;
    private Validation validation;
    private RacingService racingService;

    @BeforeEach
    public void beforeEach() {
        racingRepository = new RacingRepository();
        validation = new Validation();
        racingService = new RacingService(racingRepository, validation);
    }

    @AfterEach
    public void afterEach() {
        racingRepository.clear();
    }


    /**
     * racingService.saveCars 테스트
     */
    @Test
    void saveCars_split_구분() {
        String carsName = ("a,b,c");
        String[] cars = carsName.split(",");
        assertThat(cars).contains("a", "b");

        String carName = "a";
        String[] car = carName.split(",");
        assertThat(car).contains("a");
    }

    @Test
    void saveCars_trim_공백제거() {
        String car = " a ";
        car = car.trim();
        assertThat(car).isEqualTo("a");
    }

    @Test
    void validateCarName_검증_자동차_이름_5글자_이하() {
        assertThatThrownBy(() -> validation.validateCarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_검증_자동차_이름_입력_여부() {
        assertThatThrownBy(() -> validation.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void saveCars_메서드_리포지토리_저장() {
        racingService.saveCars("a, b, c");
        assertThat(racingRepository.findCars().size()).isEqualTo(3);
    }


    /**
     * racingService.saveAttempts 테스트
     */
    @Test
    void validateAttempts_검증_자연수() {
        assertThatThrownBy(() -> validation.validateAttempts("a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validation.validateAttempts("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void saveAttempts_parseInt_변환() {
        String attempts = "1";
        assertThat(Integer.parseInt(attempts)).isEqualTo(1);
    }

    @Test
    void saveAttempts_값_저장() {
        racingService.saveAttempts("1");
        assertThat(racingRepository.findAttempts()).isEqualTo(1);
    }


    /**
     * racingService.findCars 테스트
     */
    @Test
    void findCars_값_불러오기() {
        racingRepository.saveCar(new Car("a"));
        racingRepository.saveCar(new Car("b"));
        racingRepository.saveCar(new Car("c"));
        List<Car> cars = racingService.findCars();
        assertThat(cars.get(0).getName()).isEqualTo("a");
        assertThat(cars.get(1).getName()).isEqualTo("b");
        assertThat(cars.get(2).getName()).isEqualTo("c");
    }


    /**
     * racingService.findAttempts 테스트
     */
    @Test
    void findAttempts_값_불러오기() {
        racingRepository.saveAttempts(5);
        assertThat(racingService.findAttempt()).isEqualTo(5);
    }


    /**
     * racingService.move 테스트
     */
    @Test
    void move_pickNumberInRange_범위() {
        int check = 0;
        List<Integer> range = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 1000; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (!range.contains(randomNumber)) {
                check = 1;
            }
        }
        assertThat(check).isEqualTo(0);
    }

    @Test
    void move_증가() {
        Car car = new Car("a");
        car.move();
        assertThat(car.getMoves()).isEqualTo(1);
        car.move();
        assertThat(car.getMoves()).isEqualTo(2);
    }


    /**
     * racingService.findWinner 테스트
     */
    @Test
    void getMoves_값_확인() {
        Car car = new Car("a");
        assertThat(car.getMoves()).isEqualTo(0);
    }

    @Test
    void findWinner_winners_리스트_만들기() {
        Car carA = new Car("a");
        Car carB = new Car("b");
        Car carC = new Car("c");

        carA.move();
        carB.move();
        carB.move();
        carC.move();
        carC.move();
        carC.move();

        racingRepository.saveCar(carA);
        racingRepository.saveCar(carB);
        racingRepository.saveCar(carC);

        List<Car> winners = racingService.findWinner();
        assertThat(winners.get(0).getName()).isEqualTo("c");
    }

    @Test
    void findWinner_winners_리스트_만들기_우승_동점자() {
        Car carA = new Car("a");
        Car carB = new Car("b");
        Car carC = new Car("c");

        carA.move();
        carB.move();
        carB.move();
        carC.move();
        carC.move();

        racingRepository.saveCar(carA);
        racingRepository.saveCar(carB);
        racingRepository.saveCar(carC);

        List<Car> winners = racingService.findWinner();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("b");
        assertThat(winners.get(1).getName()).isEqualTo("c");
    }


    /**
     * OutputView 테스트
     */
    @Test
    void repeat_반복() {
        String test = "-".repeat(5);
        assertThat(test).isEqualTo("-----");

        String test2 = "-".repeat(1);
        assertThat(test2).isEqualTo("-");

        //Empty Case
        String test3 = "-".repeat(0);
        assertThat(test3).isEmpty();
    }

    @Test
    void printWinners_출력() {
        List<Car> winners = new ArrayList<>(Arrays.asList(new Car("a"), new Car("b")));
        String phrase = "최종 우승자 : ";
        for (Car winner : winners) {
            phrase += winner.getName() + ", ";
        }
        phrase = phrase.substring(0, phrase.length() - 2);
        assertThat(phrase).isEqualTo("최종 우승자 : a, b");
    }
}
