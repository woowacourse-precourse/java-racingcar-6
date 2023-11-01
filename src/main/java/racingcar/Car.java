package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void MoveOrNot() {
        int num = RandomNumber();
        if(num >= 4) {
            position += 1;
        }
    }

    public int RandomNumber() {
        int rand = Randoms.pickNumberInRange(0,9);
        return rand;
    }

    public void Visual() {
        System.out.print(name + " : ");

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int GetPosition() {
        return position;
    }

    public String GetName() {
        return name;
    }
}
