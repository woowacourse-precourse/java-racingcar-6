package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import racer.Racer;
import racer.Race;

import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void setRacers_메서드에서_5자이상_예외() {
        Race race = new Race();
        String input = "Alex,Markus";

        assertThrows(IllegalArgumentException.class, () -> {
            race.setRacers(input);
        });
    }

    @Test
    void setRacers_메서드에서_0자_입력_예외() {
        Race race = new Race();
        String input = "Alex,,James";

        assertThrows(IllegalArgumentException.class, () -> {
            race.setRacers(input);
        });
    }

    @Test
    void setRacers_메서드에서_공백_입력_예외() {
        Race race = new Race();
        String input = "Alex, ,James";

        assertThrows(IllegalArgumentException.class, () -> {
            race.setRacers(input);
        });
    }

    @Test
    void setRacers_메서드에서_탭문자_입력_예외() {
        Race race = new Race();
        String input = "Alex,\t,James";

        assertThrows(IllegalArgumentException.class, () -> {
            race.setRacers(input);
        });
    }

//    //updateNameDuplication메서드는 serRacers메서드 내부에서 실행되므로 private이지만 
//    //Test를 위해 public으로 바꾸고 해보았음.
//    @Test
//    void updateNameDuplication_메서드로_중복수_검정() {
//        Race race = new Race();
//        String[] names = {"Alex", "James", "Mark", "Alex"};
//        for(String name : names) {
//            race.updateNameDuplication(name);
//        }
//        
//        assertThat(race.nameDuplication.get("Alex")).isEqualTo(2);
//        assertThat(race.nameDuplication.get("James")).isEqualTo(1);
//        assertThat(race.nameDuplication.get("Mark")).isEqualTo(1);
//    }

    @Test
    void setRacers_메서드로_중복_없는_리스트_생성() {
        Race race = new Race();
        String input = "Alex,James";
        race.setRacers(input);

        boolean doesAlexExist = false;
        boolean doesJamesExist = false;
        for (Racer racer : race.getRacers()) {
            if (racer.getName().equals("Alex") && racer.getDuplicationCount() == 1) {
                doesAlexExist = true;
            }
            if (racer.getName().equals("James") && racer.getDuplicationCount() == 1) {
                doesJamesExist = true;
            }
        }
        assertThat(doesAlexExist && doesJamesExist).isTrue();
    }

    @Test
    void setRacers_메서드로_중복_포함_리스트_생성() {
        Race race = new Race();
        String input = "Alex,James,Alex";
        race.setRacers(input);

        boolean doesAlexExist = false;
        boolean doesJamesExist = false;
        for (Racer racer : race.getRacers()) {
            if (racer.getName().equals("Alex") && racer.getDuplicationCount() == 2) {
                doesAlexExist = true;
            }
            if (racer.getName().equals("James") && racer.getDuplicationCount() == 1) {
                doesJamesExist = true;
            }
        }
        assertThat(doesAlexExist && doesJamesExist).isTrue();
    }

    @Test
    void printRacer_메서드로_전진_거리_출력() {
        Race race = new Race();
        
        Racer Alex = new Racer("Alex", 0);
        Alex.setDisplayName("Alex");
        Alex.setAdvance(9);
        
        Racer James = new Racer("James", 0);
        James.setDisplayName("James");
        James.setAdvance(6);
        
        assertThat(race.printRacer_string(Alex)).isEqualTo("Alex : ---------\n");
        assertThat(race.printRacer_string(James)).isEqualTo("James : ------\n");
    }
    
    @Test
    void getWinner_메서드로_우승자_결정() {
        Race race = new Race();
        String input = "Alex,James,Mark,Alex";

        race.setRacers(input);

        race.getRacers().get(0).setAdvance(10);
        race.getRacers().get(1).setAdvance(0);
        race.getRacers().get(2).setAdvance(3);
        race.getRacers().get(3).setAdvance(10);

        boolean containsAlex1 = false;
        boolean containsAlex2 = false;
        for (Racer racer : race.getWinner()) {
            if (racer.getName().equals("Alex") && racer.getDisplayName().equals("Alex(1)")) {
                containsAlex1 = true;
            }
            if (racer.getName().equals("Alex") && racer.getDisplayName().equals("Alex(2)")) {
                containsAlex2 = true;
            }
        }

        assertThat(containsAlex1 && containsAlex2).isTrue();
    }

}
