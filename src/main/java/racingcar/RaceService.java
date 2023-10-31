package racingcar;

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
        return CarDtoMapper.fromCarDto(carDto);
    }

    public int getRoundFromInput(String roundInput) {
        // RoundDto 생성 이후 검증
        RoundDto roundDto = new RoundDto(roundInput);
        RoundDtoValidator.validateRoundDto(roundDto);
        // RoundDto => int 매핑
        return RoundDtoMapper.mapToRound(roundDto);
    }

    public void raceForRounds(List<Car> cars, int round) {
        // round 만큼
        for (int i = 0; i < round; i++) {
            // 전진 시도
            raceForRound(cars);

            // 현재 상태 출력
            System.out.println(RaceView.printCarsStatus(cars));
        }
    }

    public void raceForRound(List<Car> cars) {
        // 차 별로 전진 시도
        for (Car car : cars) {
            int randNum = Randoms.pickNumberInRange(0, 9);
            tryMoveForward(car, randNum);
        }
    }

    // 전진조건에 따라 , 전진을 시도합니다.
    public void tryMoveForward(Car car, int randNum) {
        if (MoveStrategy.isMovable(randNum)) {
            car.moveForward();
        }
    }

    public List<Car> getWinners(List<Car> cars) {
        // 위치 기준 내림차순 정렬된 차 리스트
        List<Car> sortedCars = cars.stream()
                .sorted(Comparator.comparingInt(Car::getCurrentLocation).reversed())
                .toList();

        // 동순위(1등과 같은 위치의 차들)들을 filtering 이후,
        // 이름 기준 오름차순 정렬하여 우승자들을 반환
        return sortedCars.stream()
                .filter(car -> car.getCurrentLocation()
                        == sortedCars.get(0).getCurrentLocation())
                .sorted(Comparator.comparing(Car::getName, Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
}
