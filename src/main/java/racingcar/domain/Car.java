package racingcar.domain;

public class Car{

    private String name;
    private int forwardCount;
    private int randomNumber;

    public Car(String name){
        throwIfInvalidNameLength(name);
        this.name = name;
        this.forwardCount = 0;
    }

    private void throwIfInvalidNameLength(String name){
        if(name.length()>5){
            throw new IllegalArgumentException("Racing car name length cannot be more than 5.");
        }
    }

    public void drive(){
        this.randomNumber = NumberGenerator.createRandomNumber();
        if(isGoingForward(this.randomNumber)){
            this.forwardCount++;
        }
    }

    private boolean isGoingForward(int number){
        return number>=4;
    }

    public void printCarState(){
        String carState = this.name+" : ";
        for(int i=0;i<this.randomNumber;i++){
            carState = carState+"-";
        }
        System.out.println(carState);
    }

    public String getName(){
        return name;
    }

    public int getForwardCount(){
        return forwardCount;
    }

}
