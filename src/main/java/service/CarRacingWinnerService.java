package service;

import domain.Car;
import domain.Cars;
import ui.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class CarRacingWinnerService {

    public void selectWinnerWithOutput(Cars cars){

        List<Car> selectedWinner = selectWinner(cars);
        Output.addResultOutput(selectedWinner);
    }
    public List<Car> selectWinner(Cars cars){
        ArrayList<Car> carList = cars.getCars();
        sort(carList);
        int lastIndex = findLastIndex(carList);
        return carList.subList(0,lastIndex);
    }

    private void sort(ArrayList<Car> carList){
        carList.sort((a, b) -> b.getMoveCount() - a.getMoveCount());
    }

    //정렬된 배열에서 우승자까지의 index 반환
    private int findLastIndex(ArrayList<Car> carList){
        int topMoveCountValue = carList.get(0).getMoveCount();
        return IntStream.range(1, carList.size())
                .filter(index -> carList.get(index).getMoveCount() != topMoveCountValue)
                .findFirst()
                .orElse(carList.size());
    }
}
