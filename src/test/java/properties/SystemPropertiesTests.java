package properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test

    void systemProperties4Test() {
        String browser = System.getProperty("browser", "firefox");

        System.out.println(browser);

    }
}
