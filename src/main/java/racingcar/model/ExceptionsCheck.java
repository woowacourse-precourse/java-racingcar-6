package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ExceptionsCheck {

    RacingData racingData = RacingData.getInstance();
    Car car = Car.getInstance();


    // Cars Exception (String)

    public boolean inputCarIsEmpty (String userInputCarString) {

        if(userInputCarString == null){
            throw new IllegalArgumentException();
        }

        return false;
    }

    public boolean ghostCarExist (String userInputCarString) {

        if(userInputCarString.contains(",,")){
            throw new IllegalArgumentException();
        }

        return false;
    }

    public int passCountInputCarString(boolean inputCarIsEmpty, boolean ghostCarExist){

        int passCount = 0;

        if(!inputCarIsEmpty){
            passCount++;
        }

        if(!ghostCarExist){
            passCount++;
        }

        return passCount;
    }

    public String passedCheckInputCarString(int passCount , String userInputCarString){
        String passedCheckString = null;
        if(passCount == 2){
            passedCheckString = userInputCarString;
        }
        return passedCheckString;
    }

    public void testInputString(){
        int passCount = 0;
        if(!inputCarIsEmpty(car.getUserInputString())){
            passCount++;
        }
        if(!ghostCarExist(car.getUserInputString())){
            passCount++;
        }
        if(passCount == 2) {
            car.setPassedTestString(car.getUserInputString());
        }
    }

    // Cars Exception (List)

    public boolean carNameLengthOvercome (List<String> carNameList) {

        for (int i = 0; i < carNameList.size(); i++) {
            if(carNameList.get(i).length()>5){
                throw new IllegalArgumentException();
            }
        }

        return false;
    }

    public boolean sameCarNameExist (List<String> carNameList) {

        HashSet<String> checkingCarNameSet = new HashSet<>(carNameList);

        if (checkingCarNameSet.size() != carNameList.size()){
            throw new IllegalArgumentException();
        }

        return false;
    }

    public int testPassCountAsCar(boolean carNameLengthOvercome ,boolean sameCarNameExist) {

        int passCount = 0;

        if(!carNameLengthOvercome){
            passCount++;
        }

        if(!sameCarNameExist){
            passCount++;
        }

        return passCount;
    }

    public List<String> passedCheckCarList(int testPassCountAsCar , List<String> carnNameList){
        List<String> passingAllTest = new ArrayList<>();
        if(testPassCountAsCar == 2) {
            passingAllTest = carnNameList;
        }
        return passingAllTest;
    }

    public void passedCheckCarList(){
        List<String> passingAllTest = new ArrayList<>();
        if(testPassCountAsCar(carNameLengthOvercome(car.getStringToList()), sameCarNameExist(car.getStringToList())) == 2) {
            passingAllTest = car.getStringToList();
        }
        car.setPassedTestList(passingAllTest);
    }

    // Loops Exception

    public boolean inputLoopIsEmpty (String userInputLoopCount ) {

        if(userInputLoopCount == null){
            throw new IllegalArgumentException();
        }

        return false;
    }

    public boolean inputLoopIsNotInteger (String userInputLoopCount) {

        for (int i = 0; i < userInputLoopCount.length(); i++) {

            char testingChar = userInputLoopCount.charAt(i);

            if(!Character.isDigit(testingChar)) {
                throw new IllegalArgumentException();
            }
        }

        return false;
    }

    public boolean inputLoopIsZero (String userInputLoopCount) {

        if(Objects.equals(userInputLoopCount, "0")){
            throw new IllegalArgumentException();
        }

        return false;
    }

    public int testPassCountAsLoop (boolean inputLoopIsEmpty, boolean inputLoopIsNotInteger, boolean inputLoopIsZero) {

        int passCountLoop = 0;

        if(!inputLoopIsEmpty){
            passCountLoop++;
        }

        if(!inputLoopIsZero){
            passCountLoop++;
        }

        if (!inputLoopIsNotInteger){
            passCountLoop++;
        }

        return passCountLoop;

    }


    public String passedCheckLoopString (int testPassCountAsLoop , String userInputLoopCount) {

        String passingAllTest = null;

        if(testPassCountAsLoop == 3) {
            passingAllTest = userInputLoopCount;
        }
        return passingAllTest;
    }

    public void passedCheckLoopString () {

        String passingAllTest = null;

        if(testPassCountAsLoop(inputLoopIsEmpty(racingData.getUserInputLoopString()),
                inputLoopIsNotInteger(racingData.getUserInputLoopString()),
                inputLoopIsZero(racingData.getUserInputLoopString())) == 3) {
            passingAllTest = racingData.getUserInputLoopString();
        }
        racingData.setPassedTestLoopString(passingAllTest);

    }

}
