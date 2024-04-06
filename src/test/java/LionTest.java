import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

@RunWith(MockitoJUnitRunner.class)
public class  LionTest {
    private static final String SEX = "Самец";
    private Lion lion;

    @Mock
    private Feline feline;
    @Test
    public void getKittensTest() throws Exception {
        lion = new Lion( SEX, feline );
        lion.getKittens();
        Mockito.verify( feline ).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        lion = new Lion( SEX, feline );
        lion.getFood();
        Mockito.verify( feline ).getFood( Mockito.anyString() );
    }

    @Test
    public void ExceptionTest() {
        Throwable throwable = catchThrowable(() -> {
            lion = new Lion("InvalidSex", feline);
        });
        assertThat(throwable)
                .hasMessage("Используйте допустимые значения пола животного - самей или самка");
    }

}


