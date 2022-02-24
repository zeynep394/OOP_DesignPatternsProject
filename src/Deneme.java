/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deneme {
    public static void main(String[] args) {

        int toplam_maliyet=0;
        List<Direktor> objList = new ArrayList<Direktor>();
        List<Employee> empList = new ArrayList<Employee>();


        FileFactory fileFactory = new FileFactory(); //Arka plandaki nesne oluşturma mantığını kullanıcıya göstermeden nesneler oluşturuyoruz
        

        FileClass file1 = fileFactory.getFile("Txt"); //arka planda bilgiler txt'den de okunsa sml'den de okunsa database'ten de çekilde farketmiyor
        //tüm tipleri FileFactory nesnesi yardımıyla FileClass tipinde oluşturuyouz bu sayede nesneleri kullanıcıdan bağımsız bir şekilde tanımlıyoruz.

        ArrayList<String> data = file1.oku();//tüm veri okuma sınıfları okudukları bilgileri tuttukları bir arraylist döndürüyorlar
        int i = 0;
            while(i<data.size()){ //bu arraylistteki string değerleri satır satır okunuyor ve hiyerarşik yapıyı oluşturmak için işlemler gerçekleşiyor.

                String line = data.get(i);
                String[] details = line.split(",");

                String employeeType = details[0];
                String empName = details[1];
                int empSalary = Integer.parseInt(details[2]);
                String owner = details[3];
                String[] objName = details[1].split(" ");//Mustafa'yı tutuyor mustafa turksever nesnesi için
                // owner kısmında sadece isim yer aldığı için adSoyad ( yani details[1] ) isim ve soyisim olmak üzere ayrılıyor ve ad objName'de tutuluyor,
                // owner adından hangi direktorun altında çalıştığının tespit edilmesi için kullanılıyor.
                //String objName = obj[0];



                if (employeeType.equals("D")) {
                    Direktor direktor = new Direktor(empName, empSalary);
                    objList.add(direktor);
                    empList.add(direktor); //yazdırma için employeeleri bir listede tutuyoruz
                    if (!owner.equals("Root")) {
                        for (Direktor emp : objList) {

                            if (owner.equals(emp.getAdSoyad().split(" ")[0])) { //orn owner= Mustafa olanların hepsni bulup direktor'un altına koyuyor.

                                if (employeeType.equals("D")) {
                                    emp.addEmployee(direktor); // direktor içine direktor atılıyor

                                }
                            }
                        }
                    }
                }
                else{
                    Memur memur = new Memur(empName,empSalary);
                    empList.add(memur);
                    if(!owner.equals("Root")){
                        for(Direktor emp:objList)
                        {
                            if(owner.equals(emp.getAdSoyad().split(" ")[0])){
                                emp.addEmployee(memur); // memur direktoru olan kisinin emplayeelist'i içine yerleşiyor.
                            }
                        }
                    }
                }

                i++;
            }


        for(Employee emp:empList)
        {
            if(emp.getAdSoyad().equals("Mustafa Turksever")||emp.getAdSoyad().equals("Oguz Demir")||emp.getAdSoyad().equals("Ahmet Egeli")){
                System.out.println(String.format("****************** %s ******************",emp.getAdSoyad()));
                emp.bilgiYazdır();
                System.out.println("Maaliyet: "+emp.countMaliyet()+" ");
                System.out.println();// memur, elemanı olduğu direktorun emplayeelist'i içine yerleşiyor.
            }

        }


    }



}





