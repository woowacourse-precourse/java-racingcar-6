package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Car {
    private List<String> car;
    private HashMap<String, Integer> carDist = new HashMap<>();
    private String userInput;

    public Car(){
        inputCar();
    }

    public void inputCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = Console.readLine();
        this.car = Arrays.stream(userInput.split(",")).toList();
        initCarDist(this.car);
    }

    public void  initCarDist(List<String> car){
        for (String element : car){
            carDist.put(element, 0);
        }
    }

    public void goCar(String carName){
        carDist.put(carName, carDist.get(carName)+1);
    }

    public List<String> getCar(){
        return car;
    }

    public HashMap<String, Integer> getCarDist() {
        return carDist;
    }
}
