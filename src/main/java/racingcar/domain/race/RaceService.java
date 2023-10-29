package racingcar.domain.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarDto;
import racingcar.domain.car.CarDtoMapper;
import racingcar.domain.car.CarDtoValidator;
import racingcar.domain.round.RoundDto;
import racingcar.domain.round.RoundDtoMapper;
import racingcar.domain.round.RoundDtoValidator;
import racingcar.domain.utils.MoveStrategy;

public class RaceService {
    private RaceService() {
    }

    private static RaceService instance;

    public static RaceService getInstance() {
        if (instance == null) {
            instance = new RaceService();
        }
        return instance;
    }

    public List<Car> getCarsFromInput(String raceCarNames) {
        // CarDto 생성 이후 검증
        CarDto carDto = new CarDto(raceCarNames);
        CarDtoValidator.validateCarDto(carDto);
        // CarDto => Car리스트 매핑
        return CarDtoMapper.mapToCar(carDto);
    }

    public int getRoundFromInput(String roundInput) {
        // RoundDto 생성 이후 검증
        RoundDto roundDto = new RoundDto(roundInput);
        RoundDtoValidator.validateRoundDto(roundDto);
        // RoundDto => int 매핑
        return RoundDtoMapper.mapToRound(roundDto);
    }

    public void raceForRounds(List<Car> cars, int round) {
        // 시도 횟수만큼 전진 혹은 멈춤
        for (int i = 0; i < round; i++) {
            // 조건에 따른 이동
            moveByStrategy(cars);
            // 현재 상태 출력
            System.out.println(RaceView.printCarsStatus(cars));
        }
    }

    public void moveByStrategy(List<Car> cars) {
        // 차 별로
        for (Car car : cars) {
            // 전진 정책에 따른 전진 수행
            int randNum = Randoms.pickNumberInRange(0, 9);
            if (MoveStrategy.isMovable(randNum)) {
                car.moveForward();
            }
        }
    }

    public List<Car> getWinners(List<Car> cars) {
        // 정렬된 차 리스트
        List<Car> sortedCars = cars.stream().sorted().toList();

        // 동순위(1등과 같은 위치의 차들)에 대한 이름 오름차순 우승자 반환
        return sortedCars.stream()
                .filter(car -> car.getCurrentLocation()
                        == sortedCars.get(0).getCurrentLocation())
                .sorted(Comparator.comparing(Car::getName, Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
}
