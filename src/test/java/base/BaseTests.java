package base;

import org.example.specs.RequestSpecs;
import org.testng.annotations.BeforeClass;


public class BaseTests {

    @BeforeClass
    public void setup() {
        RequestSpecs.initDefaultSpec();
    }

}
