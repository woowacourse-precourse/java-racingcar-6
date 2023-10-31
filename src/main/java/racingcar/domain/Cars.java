package racingcar.domain;

import racingcar.util.RandomNumber;

import java.util.*;

public class Cars {
    private UserInputCarName userInputCarName;
    public static Map<String, Integer> findMax = new HashMap<>();
    private RandomNumber randomNumber = new RandomNumber();
    public static List<Car> cars = new ArrayList<Car>();
    public Cars(String input) {
        userInputCarName = new UserInputCarName();
        List<String> carName = userInputCarName.createCarName(input);
        for(String name : carName) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public void depart(){
        for (Car car : cars){
            car.goForward(randomNumber.createRandomNumber());
        }
    }
    public static void makeHash(){
        for(Car car : cars){
            findMax.put(car.getName(), car.getForward());
        }
    }

    public static int findMaxForward(){
        makeHash();
        int maxForward = findMax.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        return maxForward;
    }

    public static List<String> getMVP(){
        int maxForward = findMaxForward();
        List<String> mvpList = new ArrayList<>();

        findMax.entrySet().stream()
                .filter(entry -> entry.getValue() == maxForward)
                .forEach(entry -> mvpList.add(entry.getKey()));

        return mvpList;
    }

    public static LinkedHashMap<String, Integer> getForwardState(){
        LinkedHashMap<String, Integer> forwardState = new LinkedHashMap<>();
        for(Car car : cars){
            forwardState.put(car.getName(), car.getForward());
        }
        return forwardState;
    }






}
