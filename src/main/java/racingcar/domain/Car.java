package racingcar.domain;

public class Car {
    private static String carNames;
    private static Integer move = 0;

    public Car(String carNames){
        this.carNames = carNames;
    }
    public void moving(){
        move+=1;
    }

    public static Integer getMove() {
        return move;
    }

    public String toString(){
        String gameResult = "";

        for (int i = 0; i < move; i++) {
            gameResult += "-";
        }
        return carNames + " : " +gameResult;
    }
}
