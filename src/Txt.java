
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Txt implements FileClass { //Txt sınıfı FileClass arayüzünü implement eder
    @Override
    public ArrayList<String> oku(){ //oku metodu TXT veri erişim yapısına göre tanımlanıyor.
    ArrayList<String> result = new ArrayList<>();
    
            try {
            java.io.File f = new java.io.File("girdi.txt");
            Scanner scOut = new Scanner(f);

            while(scOut.hasNextLine()){

                String line = scOut.nextLine();
                result.add(line.toString());
            }
                       scOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }      
return result;
    }
}
