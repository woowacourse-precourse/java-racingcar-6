package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.LinkedList;
import java.util.List;

public class UserService {
    private final int MAX_NAME_SIZE = 5;
    private static UserService INSTANCE;

    private UserService() {
    }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }

        return INSTANCE;
    }

    public List<Car> getCars() {
        String[] names = Console.readLine().split(",");

        List<Car> cars = new LinkedList<Car>();
        for (String name : names) {
            nameSizeValidation(name);

            cars.add(new Car(name));
        }

        return cars;
    }

    public int getTries() {
        String triesInput = Console.readLine();

        int tries;
        try {
            tries = Integer.parseInt(triesInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Tries input is not number!");
        }

        return tries;
    }

    private void nameSizeValidation(final String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Car name is not entered!");
        }

        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("Car name is longer than 5!");
        }
    }


}
