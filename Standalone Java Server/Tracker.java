import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * File:    Tracker.java
 * Package: PACKAGE_NAME
 * Project: TrackVirus
 * <p>
 * Class Tracker description.
 *
 * @author Orens Xhagolli
 * @version 8/6/2016
 */
public class Tracker {

    public static void main(String[] args) {
        HashMap<String, Double> world = new HashMap<>();
        try {
            FileReader fr = new FileReader("cities");
            Scanner s = new Scanner(fr);
            while(s.hasNextLine()) {
                String line = s.nextLine();
                String[] lst =  line.split("\t");
                world.put(
                        lst[0],
                        1 / ( 1 + Math.pow(
                                Math.E,
                                -(Double.parseDouble(lst[1])/1000000)
                        )
                        ) / 5
                );
            }
            
            System.out.println(world.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
