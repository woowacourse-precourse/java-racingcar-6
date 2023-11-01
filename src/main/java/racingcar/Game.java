package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    private Output myOutput;
    private Input myInput;
    private ArrayList<Car> carList;
    private int maxDistance;
    private ArrayList<String> winnerList;
    private Util myUtil;

    public Game() {
        myOutput = new Output();
        myInput = new Input();
        carList = new ArrayList<>();
        maxDistance = 0;
        winnerList = new ArrayList<>();
        myUtil = new Util();
    }

    public void run() {
        myOutput.printEnterNameOfCar();
        String input = Console.readLine();
        ArrayList<String> carNameList = myInput.getNameList(input);
        carList = new ArrayList<>(setCarList(carNameList));

        myOutput.printEnterTryTime();
        input = Console.readLine();
        int tryCount = myInput.getTryCount(input);
        myOutput.printExecutionResult();

        for (int i = 0; i < tryCount; i++) {
            movingALLCar();
            printTryResult();
        }

        calcMaxDistance();
        makeWinnerList();
        myOutput.printGameResult(winnerList);
    }

    public ArrayList<Car> setCarList(ArrayList<String> nameList) {
        ArrayList<Car> list = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            Car myCar = new Car(nameList.get(i));
            list.add(myCar);
        }
        return list;
    }

    public void movingALLCar() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).moving(myUtil.generateRandomNumber());
        }
    }

    public void printTryResult() {
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i).getName() + " : ");
            myOutput.printDashBoard(carList.get(i).getDistance());
        }
        System.out.println();
    }

    public void calcMaxDistance() {
        for (int i = 0; i < carList.size(); i++) {
            compareDistance(i);
        }
    }

    public void compareDistance(int index) {
        if (maxDistance < carList.get(index).getDistance()) {
            maxDistance = carList.get(index).getDistance();
        }
    }

    public void makeWinnerList() {
        for (int i = 0; i < carList.size(); i++) {
            getWinner(i);
        }
    }

    public void getWinner(int index) {
        if (carList.get(index).getDistance() == maxDistance) {
            winnerList.add(carList.get(index).getName());
        }
    }
}
