package carServiceTest;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.carRepository.CarRepository;
import racingcar.carRepository.CarRepositoryInterface;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.CarServiceInterface;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest {

    CarRepositoryInterface caRepository = new CarRepository();
    CarServiceInterface carService = new CarService(caRepository);

    @Test
    @DisplayName("자동차 생성 테스트")
    public void createCar() {
        // given
        String[] carNames = {"pobi"};

        // when
        carService.createCar(carNames);
        List<Car> cars = caRepository.getCars();
        String carName = cars.get(0).getName();

        //then
        Assertions.assertThat(carName).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 움직임 테스트")
    public void movieCar() {
        // given
        Car car = Car.createCar("pobi");
        caRepository.saveCar(car);

        //when
        carService.movieCar();
        List<Car> cars = caRepository.getCars();
        int carDistance = cars.get(0).getDistance();

        if (carDistance == 0) {
            Assertions.assertThat(carDistance).isEqualTo(0);
        } else {
            Assertions.assertThat(carDistance).isEqualTo(1);
        }

    }

    @Test
    @DisplayName("저장된 자동차 리스트 테스트")
    public void getCars() {
        // given
        Car car = Car.createCar("pobi");
        Car secCar = Car.createCar("pppp");
        caRepository.saveCar(car);
        caRepository.saveCar(secCar);

        //when
        List<Car> cars = carService.getCars();

        // then
        Assertions.assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("최종 결과 테스트")
    public void finalResult(){
        //given
        Car car = Car.createCar("pobi");
        Car secCar = Car.createCar("pppp");
        caRepository.saveCar(car);
        caRepository.saveCar(secCar);

        // when
        List<Car> maxDistanceCars = carService.finalResult();

        //then
        if(maxDistanceCars.size()>=1){
            if(maxDistanceCars.get(0).getDistance() ==1){
                Assertions.assertThat(maxDistanceCars.get(0).getDistance()).isEqualTo(1);
            }else{
                Assertions.assertThat(maxDistanceCars.get(0).getDistance()).isEqualTo(0);
            }
        }
    }



}
