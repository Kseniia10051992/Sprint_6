import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest  {
    private Cat cat;
    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        cat = new Cat( feline );
        String actual = cat.getSound();
        Assert.assertEquals( "Мяу", actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        cat = new Cat( feline );
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}
