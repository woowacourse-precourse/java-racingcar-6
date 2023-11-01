package racingcar.car;


public class Car {
    private final String name;
    private Integer location;
    private final RandomNumberGenerator randomNumberGenerator;

    public Car(String name, RandomNumberGenerator randomNumberGenerator){
        this.name = name;
        this.location = 0;
        this.randomNumberGenerator = randomNumberGenerator;
    }
    public void move(){
        if(randomNumberGenerator.generate() >= 4){
            location += 1;
        }
    }

    public Integer getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }
}
