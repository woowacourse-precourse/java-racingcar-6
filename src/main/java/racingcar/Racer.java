package racingcar;

public class Racer {
    String name;
    int progress;
    public Racer(String name){
        this.name = name;
        this.progress = 0;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public void increaseProgress() {
        this.progress++;
    }

    public void printRacer() {
        System.out.print(name + " : ");
        printProgress();
        System.out.println();
    }

    public void printProgress() {
        for(int i=0; i<progress; i++){
            System.out.print("-");
        }
    }
}
