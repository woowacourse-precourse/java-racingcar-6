package racingcar.controller;

import racingcar.domain.Car;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnerDto;
import racingcar.service.CarService;
import racingcar.service.RaceGameService;

import java.util.ArrayList;
import java.util.Arrays;

public class CarController {

    private final RaceGameService raceGameService = new RaceGameService();
    private final CarService carService = new CarService();

    public CarsDto generateCars(String readStr) {
        String[] strings = readStr.split(",");
        strings = Arrays.stream(strings)
                .map(String::trim)
                .toArray(String[]::new);

        // 유효성 검사
        for (String str : strings) {
            if (str.length() > 5 || str.length() < 1) {
                throw new IllegalArgumentException();
            }
        }

        return carService.createCarsByNames(strings);
    }

    public WinnerDto gameStartNTimes(CarsDto carsDto, String readStr) {
        // 유효성 검사
        if (!readStr.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
        int repeatNum = Integer.parseInt(readStr);

        if (repeatNum == 0) {
            throw new IllegalArgumentException();
        }

        // 레이스 반복
        System.out.println();
        System.out.println("실행 결과");
        CarsDto carsDto1 = carsDto;
        for (int i = 0; i < repeatNum; i++) {
            carsDto1 = raceGameService.roundStart(carsDto1);
            printCurrentState(carsDto1);
        }

        // 1등 판단
        int[] locates = carsDto.carLocates();
        int highestLocation = Arrays.stream(locates)
                .max()
                .orElse(0);

        if (highestLocation == 0) {
            return new WinnerDto(carsDto1.ownerNames());
        }

        Car[] finalCars = carsDto1.cars();
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : finalCars) {
            if (car.getLocation() == highestLocation) {
                winners.add(car.ownerOfCar());
            }
        }
        return new WinnerDto(winners.toArray(new String[0]));
    }

    private void printCurrentState(CarsDto carsDto) {
        String[] names = carsDto.ownerNames();
        int[] locates = carsDto.carLocates();
        for (int i = 0; i < names.length; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(names[i]);
            sb.append(" : ");
            sb.append("-".repeat(locates[i]));
            System.out.println(sb);
        }
        System.out.println();
    }
}
