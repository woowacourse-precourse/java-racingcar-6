package racingcar;

import java.util.ArrayList;

public class RacingCar {

    private final String name;
    private ArrayList<Integer> records;
    private int totalRecord;

    RacingCar(String name){

        this.name = name;

        this.totalRecord = 0;
        records = new ArrayList<>();
    }

    public void calculateTotalRecord(int record){

        this.totalRecord += record;
    }

    public void saveRecord(int record){

        records.add(record);
    }

    public String getName(){

        return name;
    }

    public int getTotalRecord(){

        return totalRecord;
    }

    public ArrayList<Integer> getRecords(){

        return records;
    }
}
