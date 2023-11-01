package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.dto.CarsResponseDto;
import racingcar.dto.NamesRequestDto;
import racingcar.dto.WinnerResponseDto;
import racingcar.service.CarService;

class CarControllerTest {

	private CarService carService;

	@BeforeEach
	void init() {
		carService = new CarService();
		carService.addCars(NamesRequestDto.createNamesRequestDto(List.of("aCar", "bCar", "cCar")));
	}

	@Test
	void checkNames() {
		// 기능 요구사항 중 이름만 조회하는 기능이 따로 없기 때문에 전진 여부와 상관 없이 이름 조회 용 기능 사용
		CarsResponseDto carsResponseDto = carService.raceCar();

		assertThat(carsResponseDto.cars()
			.stream()
			.map(Car::getName))
			.containsExactly("aCar", "bCar", "cCar");
	}

	@Test
	void raceCar() {
		//경주 기능은 사용자가 정의할 수 없는 랜덤의 움직임이기 때문에 101번의 경주를 통해 차 한개 이상은 전진했을 거라 가정하고 판단하는 테스트
		for (int i = 0; i < 100; i++) {
			carService.raceCar();
		}
		CarsResponseDto carsResponseDto = carService.raceCar();
		Assertions.assertThat(carsResponseDto.cars()
				.stream()
				.mapToInt(Car::getProgress)
				.anyMatch(progress -> progress > 0))
			.isTrue();
	}

	@Test
	void getWinners() {
		for (int i = 0; i < 100; i++) {
			carService.raceCar();
		}
		CarsResponseDto carsResponseDto = carService.raceCar();

		List<Car> cars = carsResponseDto.cars();
		int findMaxProgress = cars
			.stream()
			.mapToInt(Car::getProgress)
			.max()
			.getAsInt();

		List<String> winnerCars = cars.stream()
			.filter(car -> car.getProgress() == findMaxProgress)
			.map(Car::getName)
			.toList();

		WinnerResponseDto winners = carService.getWinners();
		Assertions.assertThat(winners.winnerNames()).containsAll(winnerCars);

	}
}