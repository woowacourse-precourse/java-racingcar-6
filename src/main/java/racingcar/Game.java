package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private User user;
    private List<Car> cars;
    Game(){
        user = new User();
        cars = new ArrayList<>();
        play();
    }
    private void play() {
        user.inputData();
        inputCars(user.getCarNames());
        while(checkPosition(cars)){
            cars.stream().forEach(c->c.move());
            printPosition();
        }
        printResult();

    }
    private void inputCars(List<String> carNames){
        carNames.stream().forEach(n->cars.add(new Car(n)));
    }
    private boolean checkPosition(List<Car> cars){
        if(!(cars
                .stream()
                .filter(c->c.getPosition()==(user.getNumber()))
                .toList()
                .size()>=1))return true;
        else return false;
    }
    private void printPosition(){
        System.out.println();
        cars.stream().forEach(c->{
            System.out.printf("%s : "+"-".repeat(c.getPosition()),c.getName());
            System.out.println();
        });
    }
    private void printResult(){
        System.out.println("최종 우승자 : "+
                cars.stream()
                        .filter(c->c.getPosition()==user.getNumber())
                        .map(c->c.getName())
                        .collect(Collectors.joining(", ")));
    }
}
