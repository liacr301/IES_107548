package ua.deti.ies;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import k; // other project

public class App {
    Toolkit toolkit;
    Timer timer;

    public App(){
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0,1 * 1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            List<Integer> numbers = new ArrayList<>();

            while (input != "exit"){
                new_city =
                setCity()
            }
        }
    }

    public static void main(String[] args) {


    }
}