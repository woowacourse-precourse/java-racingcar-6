package racingcar;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int player_n, i, n;
        String input;
        String[] names;

        TException te = new TException();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = Console.readLine();
        names = input.split(",");
        player_n = names.length;
        Racer[] racers = new Racer[player_n];

        System.out.println("시도할 회수는 몇회인가요?");
        n = Integer.parseInt(Console.readLine());
        
    }
}

class Racer{
    String name;
    int distance;

    public Racer(String name){
        this.name = name;
    }
    public void forward(){
        this.distance++;
    }

    public int getDistance(){
        return this.distance;
    }
}

class TException{
    public void shoot() throws IllegalArgumentException{
        throw new IllegalArgumentException();
    }
}