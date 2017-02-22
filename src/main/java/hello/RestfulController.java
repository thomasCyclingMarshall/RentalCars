package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/part1a")
    public String part1a() {
        RentalCars2 rc2 = new RentalCars2();
        try {
            rc2.readIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String part1a = rc2.part1a();
        String part1aFormatted = part1a.replaceAll("\n","<br />");
        return part1aFormatted;
    }

    @RequestMapping("/part1b")
    public String part1b() {
        RentalCars2 rc2 = new RentalCars2();
        try {
            rc2.readIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String part1b = rc2.part1b();
        String part1bFormatted = part1b.replaceAll("\n","<br />");
        return part1bFormatted;
    }

    @RequestMapping("/part1c")
    public String part1c() {
        RentalCars2 rc2 = new RentalCars2();
        try {
            rc2.readIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String part1c = rc2.part1c();
        String part1cFormatted = part1c.replaceAll("\n","<br />");
        return part1cFormatted;
    }

    @RequestMapping("/part1d")
    public String part1d() {
        RentalCars2 rc2 = new RentalCars2();
        try {
            rc2.readIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String part1d = rc2.part1d();
        String part1dFormatted = part1d.replaceAll("\n","<br />");
        return part1dFormatted;
    }
}