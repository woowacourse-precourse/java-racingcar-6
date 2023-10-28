package controller.dto;

import model.Car;

public record Winner(String name) {

    public static Winner from(final Car car) {
        return new Winner(car.getNameValue());
    }
}
