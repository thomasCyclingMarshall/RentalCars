package hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Tests {

    final double DELTA = 1e-15;

    private String car1String = "{ \"sipp\": \"CDAR\",\n" +
            "                \"name\": \"Skoda Fabia\",\n" +
            "                \"price\": 219.71,\n" +
            "                \"supplier\": \"Sixt\",\n" +
            "                \"rating\": 8.2 }";
    private String car2String = "{ \"sipp\": \"CDAR\",\n" +
            "                \"name\": \"Skoda Fabia\",\n" +
            "                \"price\": 240.71,\n" +
            "                \"supplier\": \"Europcar\",\n" +
            "                \"rating\": 8 }";

    JsonNode car1JSON;
    JsonNode car2JSON;
    Car car1;
    Car car2;


    public void setup() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        car1JSON = mapper.readTree(car1String);
        car2JSON = mapper.readTree(car2String);

        car1 = mapper.treeToValue(car1JSON, Car.class);
        car2 = mapper.treeToValue(car2JSON, Car.class);
    }


    @Test
    public void checkReadingIn() throws Exception {
        setup();
        assertEquals(car1.getName(), "Skoda Fabia");
        assertEquals(car1.getSIPPString(), "CDAR");
        assertEquals(car1.getPrice(),219.71,DELTA);
        assertEquals(car1.getSupplier(),"Sixt");
        assertEquals(car1.getRating(),8.2,DELTA);
    }

    @Test
    public void checkPriceSorting() throws Exception {
        setup();
        ArrayList<Car> testCars = new ArrayList<Car>();
        testCars.add(car2);
        testCars.add(car1);

        assertEquals(testCars.get(0).getPrice(),240.71,DELTA);

        Collections.sort(testCars,Car.comparePrice());

        assertEquals(testCars.get(0).getPrice(),219.71,DELTA);
        assertEquals(1,1);
    }

    @Test
    public void checkSipp() throws Exception {
        setup();
        CarType ct = new CarType();
        DoorsCarType dct = new DoorsCarType();
        Transmission t = new Transmission();
        FuelAirCon fac = new FuelAirCon();

        assertEquals(ct.get(car1.getSipp()[0]),"Compact");
        assertEquals(dct.get(car1.getSipp()[1]),"5 doors");
        assertEquals(t.get(car1.getSipp()[2]),"Automatic");
        assertEquals(fac.get(car1.getSipp()[3]),"Petrol/AC");

    }

    @Test public void checkScores() throws Exception {
        setup();

        car1.setVehicleScore();
        car1.setCombinedScore();

        assertEquals(car1.getVehicleScore(),7);
        assertEquals(car1.getCombinedScore(),15.2,DELTA);
    }


}