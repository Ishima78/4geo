import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;



public class GeoServesTest {
    private static long suiteStart ;
    private static    long testStartTime ;

    @BeforeAll
    public static void initSuit(){
        System.out.println("Да начнутся тесты");
        suiteStart = System.nanoTime();
    }
    @AfterAll
    public static void completeSuite(){
        System.out.println("У всего настает забвение  "+ (System.nanoTime()-suiteStart));
    }

    @BeforeEach
    public  void initTest(){
        System.out.println("Начало нового теста");
        testStartTime = System.nanoTime();
    }
    @AfterEach
    public  void cancelTast(){
        System.out.println("Тест окончен "+(System.nanoTime()-testStartTime));
    }

    @Test
    public  void byCoordinatesTest(){
        GeoServiceImpl geoServ = new GeoServiceImpl();
        var waiting = RuntimeException.class;
        assertThrows(waiting,()->geoServ.byCoordinates(2.2,2.4));
    }
    @ParameterizedTest
    @CsvSource({"'127.0.0.1','172.0.32.11','96.44.183.149','172.','96.'"})
    public void byIPTesting(String localHost ,String MoscowIp , String NewYorkIp ,
                            String startMoscow , String startNewYork){
        String local = GeoServiceImpl.LOCALHOST;
        assertEquals(local,localHost);

        String moscowLocal = GeoServiceImpl.MOSCOW_IP;
        assertEquals(moscowLocal,MoscowIp);

        String newYork = GeoServiceImpl.NEW_YORK_IP;
        assertEquals(newYork,NewYorkIp);

        String stMoscow = "172.";
        assertEquals(stMoscow, startMoscow);

        String stNewYork = "96.";
        assertEquals(stNewYork,startNewYork);


    }




}
