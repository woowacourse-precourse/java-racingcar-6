package racingcar.model;

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



    private static String userInputCarString;
    private static String passedTestString;
    private static List<String> StringToList;
    private static List<String> passedTestList;


    // getter, setter

    public String getUserInputString() {
        return userInputCarString;
    }

    public void setUserInputString(String userInputCarString) {
        Car.userInputCarString = userInputCarString;
    }


    public String getPassedTestString() {
        return passedTestString;
    }

    public void setPassedTestString(String passedTestString) {
        Car.passedTestString = passedTestString;
    }


    public List<String> getStringToList() {
        return StringToList;
    }

    public void setStringToList(List<String> StringToList) {
        Car.StringToList = StringToList;
    }


    public List<String> getPassedTestList() {
        return passedTestList;
    }

    public void setPassedTestList(List<String> passedTestList) {
        Car.passedTestList = passedTestList;
    }

}
