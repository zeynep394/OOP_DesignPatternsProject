/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class FileFactory {//factory pattern kapsamında hangi kullanılacak veri erişim yapısının belirlendiği FileFactory sınıfı tanımlanıyor 
    
    public FileClass getFile(String shapeType){
    
    if(shapeType == null){
        return null;
    }
    if(shapeType.equalsIgnoreCase("TXT")){//mainde metod çağırımında verilen parametreye göre kullanılacak veri erişim yapısı belirleniyor  
        return new Txt(); //belirlenen yapının nesnesi döndürürlüyor.
    } 
    
    return null;
    }
}
