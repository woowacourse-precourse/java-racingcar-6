package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Gamestart gst= new Gamestart();

    }
}

class Car {
    private final String name;
    private int position=0;

    public Car(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getPosition(){
        return position;
    }

    public  void run() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            position+=1;
        }
    }
}

class Gamestart {
    private final List<Car> cars = new ArrayList<>();
    private int round;

    Gamestart() {
        setCars();
        setRound();
        printResult();
    }

    public void setCars() {
        List<String> names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] nameValue = readLine().split(",");
        names = Arrays.stream(nameValue).collect(Collectors.toList());
        for(int i=0;i< nameValue.length;i++){
            exceptionNames(names.get(i));
        }
        names.forEach(name -> cars.add(new Car(name)));
    }

    private void setRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
        round = Integer.parseInt(readLine());
        System.out.println();
    }

    private void printResult() {
        HashMap<String, Integer> raceResult = new HashMap<>();

        printRacingResult(raceResult);
        printWinners(raceResult);
    }

    private void printRacingResult(HashMap<String, Integer> raceResult) {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            game(raceResult);
            System.out.println();
        }
    }

    public void game(HashMap<String, Integer> raceResult) {
        cars.forEach(car -> {
            car.run();
            String name = car.getName();
            int position = car.getPosition();
            raceResult.put(name, position);
            printEachCarRacingResult(name, position);
        });

    }
    private void printEachCarRacingResult(String name, int position) {
        StringBuilder stb = new StringBuilder(name + " : ");
        Optional<String> formattedPosition = Stream.generate(() -> "-").limit(position).reduce((a, b) -> a + b);
        //Optional 객체, Optional은 어떤 객체를 내부에 갖고 있으며, get()등의 메소드들을 제공한다.
        //Optional이 객체를 갖고 있지 않을 때는 null이 저장.
        formattedPosition.ifPresent(stb::append);
        System.out.println(stb);
    }

    private void printWinners(HashMap<String, Integer> raceResult) {
        int maxlength = Collections.max(raceResult.values());
        String winnerName = raceResult.entrySet().stream().filter(m -> m.getValue() == maxlength).map(Map.Entry::getKey).collect(Collectors.joining(","));

        System.out.print("최종 우승자 : " + winnerName);
    }

    private void exceptionNames(String name){
        if(name.length()<1){
            throw new IllegalArgumentException();
        }
        if(name.length()>5){
            throw new IllegalArgumentException();
        }
    }

    private void exceptionRound(String round){
        try{
            Integer.parseInt(round);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(round)<1) {
            throw new IllegalArgumentException();
        }
    }

}
