package hello;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by tomas on 21/02/2017.
 */
public class Car {

    private char[] sipp;
    private String name;
    private double price;
    private String supplier;
    private double rating;
    private int vehicleScore;
    private double combinedScore;

//    public Car(char[] sipp, String name, int price, String supplier, int rating) {
//        this.sipp = sipp;
//        this.name = name;
//        this.price = price;
//        this.supplier = supplier;
//        this.rating = rating;
//    }

    public char[] getSipp() {
        return sipp;
    }

    public void setSipp(char[] sipp) {
        this.sipp = sipp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVehicleScore() {
        return vehicleScore;
    }

    public double getCombinedScore() {
        return combinedScore;
    }

    public void setCombinedScore() {
        this.combinedScore = rating + vehicleScore;
    }

    static Comparator<Car> comparePrice() {
        return new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                if (o1.getPrice() > o2.getPrice()) return 1;
                if (o1.getPrice() < o2.getPrice()) return -1;
                return 0;
            }
        };
    }

    static Comparator<Car> compareRating() {
        return new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                if (o1.getRating() > o2.getRating()) return -1;
                if (o1.getRating() < o2.getRating()) return 1;
                return 0;
            }
        };
    }

    static Comparator<Car> compareCombinedScore() {
        return new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                if (o1.getCombinedScore() > o2.getCombinedScore()) return -1;
                if (o1.getCombinedScore() < o2.getCombinedScore()) return 1;
                return 0;
            }
        };
    }

    @Override
    public String toString() {
        return "Car{" +
                "sipp=" + Arrays.toString(sipp) +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supplier='" + supplier + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getSIPPString() {
        StringBuilder sb = new StringBuilder();
        for (char c : sipp) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void setVehicleScore() {
        int score = 0;
        if (sipp[2] == 'M') score += 1;
        if (sipp[2] == 'A') score += 5;
        if (sipp[3] == 'R') score += 2;
        this.vehicleScore = score;
    }
}
