package racingcar;

public class Game {

	public static void playGame() {
    	UserInput ui = new UserInput();
    	CreateNumber cr = new CreateNumber();
    	ui.Input();
    	
    	String[] names = ui.getNames();
    	int count = ui.getCount();
    	
    	int i,j;
    	
    		for(j = 0; j<count ; j++) {
    			for (i = 0; i<names.length;i++) {
    			System.out.println(names[i]+":"+cr.addString());
    		}
    			System.out.println("");
    	}
	}
}
