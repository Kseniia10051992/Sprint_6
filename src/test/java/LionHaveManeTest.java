import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionHaveManeTest {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private Feline feline;
    private Lion lion;
    private String sex;
    private boolean hasMane;

    public LionHaveManeTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {MALE, true},
                {FEMALE, false}
        };
    }


    @Test
    public void haveManeTest() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", hasMane, actual);
    }
}






