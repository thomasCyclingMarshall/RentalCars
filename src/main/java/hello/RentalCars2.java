/**
 * Created by tomas on 21/02/2017.
 */

//import com.fasterxml.jackson.*;
package hello;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class RentalCars2 {
    private ArrayList<Car> cars;

    //sipp lookup objects
    private CarType ct = new CarType();
    private DoorsCarType dct = new DoorsCarType();
    private Transmission t = new Transmission();
    private FuelAirCon fac = new FuelAirCon();

    public static void print(String string) {
        System.out.println(string);
    }

    public void readIn() throws Exception {
        InputStream is = new URL("http://www.rentalcars.com/js/vehicles.json").openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String line = rd.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
//                print(line);
                sb.append(line);
                line = rd.readLine();
            }
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(sb.toString());
            JsonNode searchNode = root.path("Search");
            JsonNode vehicleListNode = searchNode.path("VehicleList");
            Iterator<JsonNode> it = vehicleListNode.elements();
            cars = new ArrayList<Car>();
            while (it.hasNext()) {
                cars.add(mapper.treeToValue(it.next(), Car.class));
            }
        } catch (Exception e) {
            print("Error: " + e);
        } finally {
            is.close();
        }
    }

    public String part1a() {
        StringBuilder sb = new StringBuilder();
        sb.append("part 1a \n");

        Collections.sort(cars,Car.comparePrice());

        for(Car c: cars) {
            sb.append(cars.indexOf(c)+1 + ". " +
                    c.getName() + " - £" + c.getPrice() + "\n");
        }
        return sb.toString();
    }

    public String part1b() {
        StringBuilder sb = new StringBuilder();

        sb.append("part 1b \n");




        for(Car c: cars) {
            char[] sipp = c.getSipp();
            sb.append(cars.indexOf(c)+1 + ". " +
                    c.getName() + " - " +
                    c.getSIPPString() + " - " +
                    ct.get(sipp[0]) + " - " +
                    dct.get(sipp[1]) + " - " +
                    t.get(sipp[2]) + " - " +
                    fac.get(sipp[3]) + "\n"
            );
        }

        return sb.toString();
    }

    public String part1c() {
        StringBuilder sb = new StringBuilder();

        sb.append("part 1c \n");

        ArrayList<Car> topCars = new ArrayList<Car>();
        Car topCar = null;

        // iterate through cars looking for matches by type
        for(Iterator<Character> type = ct.getCarType().keySet().iterator(); type.hasNext(); ) {
            char ty = type.next();
            for(Car c : cars) {
                if (c.getSipp()[0] == ty) {
                    if (topCar == null) {
                        topCar = c;
                    }
                    if (c.getRating() > topCar.getRating()) {
                        topCar = c;
                    }
                }

            }
            if (topCar != null) topCars.add(topCar); //not all of the car types are represented
            topCar = null;
        }

        Collections.sort(topCars,Car.compareRating());
        for(Car c: topCars) {
            sb.append(topCars.indexOf(c)+1 + ". " +
                    c.getName() + " - " +
                    ct.get(c.getSipp()[0]) + " - " +
                    c.getSupplier() + " - " +
                    c.getRating() + "\n"
            );
        }
        return sb.toString();
    }

    public String part1d() {
        StringBuilder sb = new StringBuilder();
        sb.append("part 1d \n");

        //calculate score from sipp - could do this at object construction time, but it's clearer for the purpose of the exercise to put it here.
        for(Car c : cars) {
            c.setVehicleScore();
            c.setCombinedScore();
        }

        Collections.sort(cars,Car.compareCombinedScore());

        for(Car c : cars) {
            sb.append(cars.indexOf(c)+1 + ". " +
                    c.getName() + " - " +
                    ct.get(c.getSipp()[0]) + " - " +
                    c.getRating() + " - " +
                    c.getCombinedScore() + "\n"
            );
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        RentalCars2 rc2 = new RentalCars2();
        rc2.readIn();

        //part 1a
        print(rc2.part1a());

        //part 1b
        print(rc2.part1b());

        //part 1c
        print(rc2.part1c());

        //part 1d
        print(rc2.part1d());
    }
}
