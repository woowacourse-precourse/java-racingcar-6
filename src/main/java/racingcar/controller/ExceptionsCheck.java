package racingcar.controller;

import com.sun.source.tree.UsesTree;
import racingcar.model.Car;
import racingcar.model.RacingData;

import java.util.HashSet;
import java.util.List;

public class ExceptionsCheck {

    RacingData racingData = RacingData.getInstance();
    Car car = Car.getInstance();

    // Cars Exception
    public boolean inputCarIsEmptyTest () {
        
        if(car.getUserInputString() == null){
            throw new IllegalArgumentException();
        }

        return true;
    }

    public boolean ghostCarTest () {

        if(car.getUserInputString().contains(",,")){
            throw new IllegalArgumentException();
        }

        return true;
    }

    public void testInputString(){

        int passCount = 0;

        if(inputCarIsEmptyTest()){
            passCount++;
        }

        if(ghostCarTest()){
            passCount++;
        }

        if(passCount == 2) {
            car.setPassedTestString(car.getUserInputString());
        }

    }

    public boolean carNameLengthTest () {

        for (int i = 0; i < car.getStringToList().size(); i++) {
            if(car.getStringToList().get(i).length()>5){
                throw new IllegalArgumentException();
            }
        }

        return true;
    }

    public boolean carNameIsNull () {
       
        for (String carName : car.getStringToList()) {
            if(carName == null){
                throw new IllegalArgumentException();
            }
        }
        
        return true;
    }

    public boolean sameCarNameExist () {
       
        HashSet<String> checkingCarNameSet = new HashSet<>(car.getStringToList());
        
        if (checkingCarNameSet.size() != car.getStringToList().size()){
            throw new IllegalArgumentException();
        }
        
        return true;
    }

    public int testPassCountAsCar() {
       
        int passCount = 0;

        if(carNameIsNull()) {
            passCount++;
        }

        if(carNameLengthTest()){
            passCount++;
        }

        if(sameCarNameExist()){
            passCount++;
        }

        return passCount;
    }

    public void testPassed(int testPassCountAsCar){
        
        if(testPassCountAsCar == 3) {
            List<String> passingAllTest = car.getStringToList();
            car.setPassedTestList(passingAllTest);
        }

    }


    // Loops Exception


    public boolean inputloopIsEmptyTest () {

        if(racingData.getUserInputLoopString() == null){
            throw new IllegalArgumentException();
        }

        return true;
    }

    public boolean inputLoopIsNotInteger () {

        String uncheckedLoopString = racingData.getUserInputLoopString();

        for (int i = 0; i < uncheckedLoopString.length(); i++) {

            char testingChar = racingData.getUserInputLoopString().charAt(i);

            if(!Character.isDigit(testingChar)) {
                throw new IllegalArgumentException();
            }
        }

        return true;
    }


    public int testPassCountAsLoop () {

        int passCountLoop = 0;

        if(inputloopIsEmptyTest()){
            passCountLoop++;
        }

        if (inputLoopIsNotInteger()){
            passCountLoop++;
        }

        return passCountLoop;

    }

    public void testInputLoopString (int testPassCountAsLoop) {

        if(testPassCountAsLoop() == 2) {
            racingData.setPassedTestLoopString(racingData.getUserInputLoopString());
        }

    }

}
