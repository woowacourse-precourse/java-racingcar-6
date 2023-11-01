package racingcar;
import racingcar.name.Name;
import racingcar.name.go;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Name names = new Name();
        go wow = new go();
        String[] listlist = names.NameList(names.getName());

        int[] distance = new int[listlist.length];
        for (int i = 0; i < listlist.length; i++){
            distance[i]=0;
        }


    }
}
