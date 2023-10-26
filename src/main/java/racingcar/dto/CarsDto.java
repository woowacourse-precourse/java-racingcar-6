package racingcar.dto;

import racingcar.domain.Car;


public record CarsDto(Car[] cars) {

    public String[] ownerNames() {
        String[] names = new String[cars.length];
        for (int i = 0; i < cars.length; i++) {
            names[i] = cars[i].ownerOfCar();
        }
        return names;
    }

    public int[] carLocates() {
        int[] locates = new int[cars.length];
        for (int i = 0; i < cars.length; i++) {
            locates[i] = cars[i].getLocation();
        }
        return locates;
    }
}
