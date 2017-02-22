package hello;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by tomas on 21/02/2017.
 */


class CarType {
    private Map<Character,String> carType = new HashMap<Character,String>();
    public CarType() {
        carType.put('M', "Mini");
        carType.put('E', "Economy");
        carType.put('C', "Compact");
        carType.put('I', "Intermediate");
        carType.put('S', "Standard");
        carType.put('F', "Full Size");
        carType.put('P', "Premium");
        carType.put('L', "Luxury");
        carType.put('X', "Special");
    }
    public String get(char c) {
        return carType.get(c);
    }

    public Map<Character, String> getCarType() {
        return carType;
    }
}

class DoorsCarType {
    private Map<Character,String> doorCarsType = new HashMap<Character,String>();
    public DoorsCarType() {
        doorCarsType.put('B', "2 doors");
        doorCarsType.put('C', "4 doors");
        doorCarsType.put('D', "5 doors");
        doorCarsType.put('W', "Estate");
        doorCarsType.put('T', "Convertible");
        doorCarsType.put('F', "SUV");
        doorCarsType.put('P', "Pick Up");
        doorCarsType.put('V', "Passenger Van");
    }
    public String get(char c) {
        return doorCarsType.get(c);
    }
}

class Transmission {
    private Map<Character,String> transmission = new HashMap<Character,String>();
    public Transmission() {
        transmission.put('M', "Manual");
        transmission.put('A', "Automatic");
    }
    public String get(char c) {
        return transmission.get(c);
    }
}

class FuelAirCon {
    private Map<Character,String> fuelAirCon = new HashMap<Character,String>();
    public FuelAirCon() {
        fuelAirCon.put('N', "Petrol/no AC");
        fuelAirCon.put('R', "Petrol/AC");
    }
    public String get(char c) {
        return fuelAirCon.get(c);
    }
}


