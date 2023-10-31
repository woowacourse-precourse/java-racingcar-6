package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRepository;

public class RacingCarGenerateController {
    private CarRepository carRepository = CarRepository.getInstance();
    static final int NAME_LENGTH = 5;

    public void generateCar(String inputName) {
        String[] nameArr;

        checkNull(inputName);
        nameArr = splitNames(inputName);
        checkLength(nameArr);
        setCarList(nameArr);
    }

    public String[] splitNames(String t) {
        return t.split(",");
    }

    public void setCarList(String[] nameArr) {
        for (String s : nameArr)
            carRepository.insertCar(new Car(s));
    }

    public int setRacingCount(String inputCount) {
        checkNull(inputCount);
        checkDigit(inputCount);
        return Integer.parseInt(inputCount);
    }

    public void checkNull(String s) {
        if (s.equals("\n")) throw new IllegalArgumentException();
    }

    public void checkLength(String[] nameArr) {
        for (String name : nameArr)
            if (name.length() > NAME_LENGTH) throw new IllegalArgumentException();
    }

    public void checkDigit(String s) {
        int i = 0;
        while (i < s.length()) {
            if (!Character.isDigit(s.charAt(i))) throw new IllegalArgumentException();
            i++;
        }
    }
}
