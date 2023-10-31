package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

class ServiceTest {

    Service service = new Service();

    CarsDto carsDto;

    @BeforeEach
    void beforeEach() {
        String[] names = {"123", "abc", "가나다"};
        ArrayList<String> carsName = new ArrayList<>();
        carsName.addAll(Arrays.asList(names));

        ArrayList<CarDto> carDtoArrayList = new ArrayList<>();
        carsName.stream()
                .forEach(carName -> carDtoArrayList.add(new CarDto(carName)));
        carsDto = new CarsDto(carDtoArrayList);
        service.initRepository();

    }

    @Test
    void 입력_받은_자동차_저장_테스트() {
        service.saveCarsToRepository(carsDto);
        CarsDto allCars = service.carRepository.findAllCars();
        for (int i = 0; i < allCars.getCarArrayList().size(); i++) {
            assertThat(allCars.getCarArrayList().get(i).getCarName()).isEqualTo(
                    carsDto.getCarArrayList().get(i).getCarName());
        }
    }

    @Test
    void 주어진_회수_만큼_시도_테스트() {
        int trialNumber = Randoms.pickNumberInRange(1, 100);
        service.saveCarsToRepository(carsDto);
        ArrayList<CarsDto> carsDtoArrayList = service.racingGivenTrialNumber(trialNumber);
        assertThat(carsDtoArrayList.size()).isEqualTo(trialNumber);
    }

    @Test
    void 우승자_출력_테스트() {
        service.saveCarsToRepository(carsDto);
        CarsDto winner = service.getWinner();
        assertThat(winner.getCarArrayList().size()).isEqualTo(carsDto.getCarArrayList().size());
    }

    @Test
    void 레포지토리_초기화_테스트() {
        service.saveCarsToRepository(carsDto);
        service.initRepository();
        assertThat(service.carRepository.findAllCars().getCarArrayList().size()).isEqualTo(0);
    }

    @Test
    void 다른_레포지토리_인스턴스_생성_테스트() {
        Service service1 = new Service();
        Service service2 = new Service();

        assertThat(service1.carRepository).isNotEqualTo(service2.carRepository);
    }

}