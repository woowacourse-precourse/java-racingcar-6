package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Constant;
import racingcar.model.RaceGame;
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
        for(String name : car_names){
            cars.add(new Car(name));
        }

        return cars;
    }

    public static ArrayList<String> convertStringToArrayList(String names) {
        ArrayList<String> name_list = new ArrayList<>();
        for(String n : names.split(",")){
            String name = n.trim();
            checkNameValidation(name);
            name_list.add(name);
        }

        return name_list;
    }

    public static Integer convertStringToInteger(String cnt) {
        try{
            Integer number = Integer.parseInt(cnt);
            return number;
        } catch(Exception e){
            throw new IllegalArgumentException("Execution cnt must be Integer type");
        }
    }

    public static void checkNameValidation(String name) {
        if(name.length() > Constant.MAX_LEN_OF_CAR_NAME){
            throw new IllegalArgumentException("The length of name of car is too long");
        }
    }

    public static void checkExecutionCntValidation(Integer execution_cnt) {
        if(execution_cnt < 0){
            throw new IllegalArgumentException("The execution count must be positive integer");
        }
    }
}
