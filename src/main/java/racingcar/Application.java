package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = scanner.nextLine();
        String[] carNames = inputNames.split(",");
        for(String name : carNames){
            if(name.length()>5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        System.out.println("시도할 횟수는 몇회인가요?");
        int attempts = scanner.nextInt();

        Race race = new Race(Arrays.asList(carNames), attempts);
        race.startRace();
        race.printWinners();
    }
}

class Car {
    private String name;
    private int position=0;

    public Car(String name){
        this.name=name;
    }

    public void move(){
        if(Randoms.pickNumberInRange(0,9)>=4){
            position++;
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
}

class Race {
    private List<Car> carList;
    private  int attempts;

    public Race(List<String> carNames, int attempts){
        this.carList=carNames.stream().map(Car::new).collect(Collectors.toList());
        this.attempts=attempts;
    }

    public void startRace(){
        for(int i=0; i<attempts; i++){
            for(Car car : carList){
                car.move();
                System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
            }
            System.out.println();
        }
    }

    public void printWinners(){
        int maxPosition = carList.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = carList.stream().filter(car->car.getPosition()==maxPosition)
                .map(Car::getName).collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", "+winners));
    }
}

class RandomGenerator{

}

class InputValidator{

}

class InputManger{

}
