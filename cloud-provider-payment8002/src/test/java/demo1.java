import org.junit.Test;

import java.util.Locale;

public class demo1 {
    @Test
    public void demo2(){
        String s = "EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.";
        System.out.println(s.toLowerCase(Locale.ROOT));
    }
}
