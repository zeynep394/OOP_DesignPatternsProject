/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


//NOT: Bu Proje Java with Ant olarak oluşturulduğu için Junit test çalıştırılırken sorunla karşılaşıldı.
//Bu sebeple Junit ile gerçekleştirilen MemurTest sınıfını Maven ile proje oluşturulatrak orada gerçekleştirildi.



/**
 *
 * @author User
 */
public class MemurTest {
    
    public MemurTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws IOException {
        System.out.println("Cleaning the screen...");
        if (System.getProperty("os.name").startsWith("Window"))
            Runtime.getRuntime().exec("cls");
        else
            try {
                Runtime.getRuntime().exec("clear");
        } catch (IOException ex) {
            Logger.getLogger(MemurTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterEach
    public void tearDown() {
        Runtime r=Runtime.getRuntime();
        System.out.println("Collecting the garbage....");
        r.gc();
    }

    /**
     * Test of countMaliyet method, of class Memur.
     */
    
     @Test
    void testMemur(){
        Memur emre =new Memur("Emre Kosar",700);

        assertNotNull(emre, "Memur is not created...");
    }

    @Test
    public void testCountMaliyet() {
        System.out.println("countMaliyet");
        Memur emre = new Memur("Emre Kosar",700);
        int expResult =700;
        int result = emre.countMaliyet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of bilgiYazdır method, of class Memur.
     */
    @Test
    public void testBilgiYazdır() {
        System.out.println("bilgiYazd\u0131r");
        Memur emre = new Memur("Emre Kosar",700);
        emre.bilgiYazdır();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
