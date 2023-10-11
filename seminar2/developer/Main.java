package seminar2.developer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FullStackDeveloper fullStackDev = new FullStackDeveloper();
        fullStackDev.writeBackEndCode();
        fullStackDev.writeFrontEndCode();

        Random rnd = new Random();
        int devTeamCounter = rnd.nextInt(1, 25);
        List<Developer> developersTeam = new ArrayList<>();

        for (int i = 0; i < devTeamCounter; i++) {
            switch (rnd.nextInt(1, 4)) {
                case 1 -> developersTeam.add(new FrontEndDeveloper());
                case 2 -> developersTeam.add(new FullStackDeveloper());
                case 3 -> developersTeam.add(new BackEndDeveloper());
            }
        }

        for (Developer dev: developersTeam) {
            if (dev instanceof FrontEndDeveloper) {
                System.out.print(dev.getClass() + " - ");
                ((FrontEndDeveloper) dev).developGUI();
            } else if (dev instanceof FullStackDeveloper){
                System.out.print(dev.getClass() + " : ");
                System.out.println("shouldn't create GUI by task's condition.");
            } else {
                System.out.print(dev.getClass() + " : ");
                System.out.println("can't create GUI.");
            }
        }
    }
}
