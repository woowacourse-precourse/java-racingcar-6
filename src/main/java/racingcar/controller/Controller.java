package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Constant;
import racingcar.model.RaceGame;
import racingcar.view.Message;
import racingcar.view.UserInput;
import racingcar.view.UserOutput;

import java.util.ArrayList;

public class Controller {
    public static void startRace() {
        RaceGame raceGame = initRace();
        UserOutput.consoleOutExecutionStart();
        Service.raceStart(raceGame);
        UserOutput.consoleOutWinner(raceGame.getWinner());
    }

    public static RaceGame initRace() {
        ArrayList<String> car_names = convertStringToArrayList(UserInput.inputCarNames());
        Integer execution_num = convertStringToInteger(UserInput.inputExecutionCount());
        return raceSetting(car_names, execution_num);
    }

    public static RaceGame raceSetting(ArrayList<String> car_names, Integer execution_cnt) {
        ArrayList<Car> cars = makeCarInstances(car_names);

        return new RaceGame(cars, execution_cnt);
    }

    public static ArrayList<Car> makeCarInstances(ArrayList<String> car_names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : car_names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public static ArrayList<String> convertStringToArrayList(String names) {
        ArrayList<String> name_list = new ArrayList<>();
        for (String n : names.split(",")) {
            String name = n.trim();
            checkNameValidation(name);
            name_list.add(name);
        }

        return name_list;
    }

    public static Integer convertStringToInteger(String cnt) {
        int result;
        try {
            result = Integer.parseInt(cnt);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.EXECUTION_INPUT_TYPE_ERROR);
        }

        if(result <= 0){
            throw new IllegalArgumentException(Message.EXECUTION_INPUT_TYPE_ERROR);
        }

        return result;
    }

    public static void checkNameValidation(String name) {
        if (name.length() > Constant.MAX_LEN_OF_CAR_NAME) {
            throw new IllegalArgumentException(Message.NAME_INPUT_LENGTH_ERROR);
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException(Message.NAME_INPUT_NULL_ERROR);
        }
    }
}
