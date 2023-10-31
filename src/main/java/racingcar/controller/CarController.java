package racingcar.controller;

import racingcar.dto.CarsDto;
import racingcar.dto.WinnerDto;
import racingcar.service.CarService;
import racingcar.service.RaceGameService;

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
        for (int i = 0; i < repeatNum; i++) {
            raceGameService.roundStart(carsDto);
            printCurrentState(carsDto);
        }

        return raceGameService.findWinner(carsDto);
    }

    private void printCurrentState(CarsDto carsDto) {
        String[] names = carsDto.ownerNames();
        int[] locates = carsDto.carLocates();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " : " + "-".repeat(locates[i]));
        }
        System.out.println();
    }
}
