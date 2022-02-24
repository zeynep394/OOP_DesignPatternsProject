
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public interface FileClass { //factory pattern kapsamında subclasslar tarafından kullanılan FileClass metodu tanımlanıyor.
    ArrayList<String> oku(); //her veri erişim yapısı için oku metodu, o veri erişim yapısına özel olarak tanımlanacak 
    //bu sebeple oku metodu abstract metod olarak tanımlanıyor.
}
