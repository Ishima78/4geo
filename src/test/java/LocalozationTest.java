import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
public class LocalozationTest {
 @ParameterizedTest
    @CsvSource({"'Добро пожаловать','Welcome'"})
    public void localTest(String russianHi, String englishHi){
     String rus = "Добро пожаловать";
     assertEquals(rus,russianHi);

     String eng = "Welcome";
     assertEquals(eng,englishHi);


 }





}
