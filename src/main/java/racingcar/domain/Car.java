package racingcar.domain;

public class Car implements Comparable {
    private final String carName;
    private int process;

    public Car(String carName) {
        this.carName = carName;
        this.process = 0;
    }

    public String getCarName(){
        return carName;
    }

    public void increaseProcess(){
        process++;
    }

    public String info(){
        String processString = "-".repeat(process);
        return String.format("%s : %s\n", carName, processString);
    }

    public int getProcess() {
        return process;
    }

    @Override
    public int compareTo(Object o) {
        Car c = (Car)o;
        return c.process-this.process;
    }

    public boolean isWinner(int max){
        if(this.process>=max) return true;
        return false;
    }
}
