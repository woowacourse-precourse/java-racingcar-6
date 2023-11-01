package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private class Car{
        String name;
        int length;
        int curLength;

        public Car(String name, int length, int curLength) {
            this.name = name;
            this.length = length;
            this.curLength = curLength;
        }
    }

    public String[] getInput(){
        String input = Console.readLine();

        String[] inputs = splitInput(input);

        for(String s : inputs)
            checkLength(s);

        return inputs;
    }

    public void checkLength(String s){
        if(s.length() > 5 || s.length() <= 0)
            throw new IllegalArgumentException("String index out of range: 5");
    }

    public String[] splitInput(String input){
        String[] result = null;

        try{
            result = input.split(",");
        }catch (Exception e){
            throw new IllegalArgumentException("Wrong input");
        }

        return result;
    }

    public void runOrStop(Car[] cars){
        for(int i = 0; i < cars.length; i++){
            int randNum = Randoms.pickNumberInRange(0, 9);

            if(randNum >= 4)
                cars[i].curLength = 1;
            else
                cars[i].curLength = 0;
        }
    }

    public void printCar(Car[] cars, StringBuilder sb){
        for(int i = 0; i < cars.length; i++){
            sb.append(cars[i].name + " " + ": ");

            printRunCar(cars[i], sb);
            sb.append("\n");
        }

        sb.append("\n");
    }

    public void printRunCar(Car car, StringBuilder sb){
        sb.append("-".repeat(car.length));

        if(car.curLength == 1)
            sb.append("-");
    }

    public void carStateInit(Car[] cars){
        for(int i = 0; i < cars.length; i++){
            cars[i].length += cars[i].curLength;
            cars[i].curLength = 0;
        }
    }

    public String checkMaxCar(Car car, int maxLength){
        if(car.length == maxLength)
            return car.name;

        return "";
    }

    public List<String> getMaxCarWithoutNotNull(List<String> list){
        List<String> result = new ArrayList<>();

        result = list.stream()
                .filter(e -> !e.equals(""))
                .collect(Collectors.toList());

        return result;
    }

    public void printResult(Car[] cars, StringBuilder sb){
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.length - o2.curLength;
            }
        });

        int maxLength = cars[0].length;

        sb.append("최종 우승자 : ");

        List<String> list = new ArrayList<>();
        for(int i = 0; i < cars.length; i++) {
            list.add(checkMaxCar(cars[i], maxLength));
        }

        list = getMaxCarWithoutNotNull(list);

        for(int i = 0; i < list.size() - 1; i++)
            sb.append(list.remove(0) + ", ");

        sb.append(list.remove(0));
    }

    public void race(){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = getInput();

        System.out.println("시도할 회수는 몇회인가요?");
        int raceCnt = Integer.parseInt(Console.readLine());
        int carCnt = input.length;

        Car[] cars = new Car[carCnt];
        for(int i = 0; i < input.length; i++)
            cars[i] = new Car(input[i], 0, 0);

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < raceCnt; t++){
            runOrStop(cars);
            printCar(cars, sb);
            carStateInit(cars);
        }

        printResult(cars, sb);

        try {
            bw.write("실행 결과");
            bw.write(sb.toString());
            bw.close();
        }catch (IOException e){}
    }
}
