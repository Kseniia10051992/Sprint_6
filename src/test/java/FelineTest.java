import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest  {
    private static final String FAMILY = "Кошачьи";
    private static final int KITTENS = 1;
    private int kittensCount = 4;

    @Spy
    private Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        String actual = feline.getFamily();
        String expected = FAMILY;
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        Assert.assertEquals( "Значения не совпадают", expected, actual );
    }

    @Test
    public void getKittensTest() {
        int actual = feline.getKittens();
        int expected = KITTENS;
        Mockito.verify(feline).getKittens();
        Assert.assertEquals( "Количество не совпадает", expected, actual);
    }

    @Test
    public void getKittensCountTest() {
        int actual = feline.getKittens(4);
        int expected = kittensCount;
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        Assert.assertEquals( "Количество не совпадает", expected, actual );
    }
}