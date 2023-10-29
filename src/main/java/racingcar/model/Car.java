package racingcar.model;

import racingcar.controller.DataConverter;
import racingcar.controller.TakeInputs;

import java.util.HashSet;
import java.util.List;

public class Car {

    private static Car instance;
    private Car(){

    }
    public static Car getInstance() {
        if (instance == null) {
            instance = new Car();
        }
        return instance;
    }


    private static String userInputString;
    private static String passedTestString;
    private static List<String> StringToList;
    private static List<String> passedTestList;


    // getter, setter

    public String getUserInputString() {
        return userInputString;
    }

    public void setUserInputString(String userInputString) {
        this.userInputString = userInputString;
    }


    public String getPassedTestString() {
        return passedTestString;
    }

    public void setPassedTestString(String passedTestString) {
        this.passedTestString = passedTestString;
    }


    public List<String> getStringToList() {
        return StringToList;
    }

    public void setStringToList(List<String> StringToList) {
        this.StringToList = StringToList;
    }


    public List<String> getPassedTestList() {
        return passedTestList;
    }

    public void setPassedTestList(List<String> passedTestList) {
        this.passedTestList = passedTestList;
    }

}
