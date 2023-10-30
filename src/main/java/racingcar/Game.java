package racingcar;

public class Game {
    private Output myOutput;
    public Game(){
        myOutput = new Output();
    }
    public void run(){
        myOutput.printEnterNameOfCar();

        myOutput.printEnterTryTime();
    } 
}
