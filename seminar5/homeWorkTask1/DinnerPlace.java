package seminar5.homeWorkTask1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DinnerPlace {

    private ArrayList<String> dinnerPlaceGuests;
    private Thread lastGuest;

    public DinnerPlace() {
        this.dinnerPlaceGuests = new ArrayList<>();
    }

    public void setLastGuest(Thread lastGuest) {
        this.lastGuest = lastGuest;
    }

    public Thread getLastGuest() {
        return lastGuest;
    }

    public ArrayList<String> getDinnerPlaceGuests() {
        return dinnerPlaceGuests;
    }

    public boolean addGuests(Thread thread){
        boolean result = false;
        if (lastGuest == null || !lastGuest.getName().equals(thread.getName())) {
            setLastGuest(thread);
            dinnerPlaceGuests.add(thread.getName() + " " + LocalDateTime.now());
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "DinnerPlaceGuests are: " +
                "dinnerPlaceGuests=" + dinnerPlaceGuests +
                ' ';
    }
}
