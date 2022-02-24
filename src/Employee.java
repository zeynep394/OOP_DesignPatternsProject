/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public abstract class Employee {//üst tipte Employee soyut sınıfı oluşturuluyor
    
  
    private String adSoyad;
    private int maas;
    private Direktor direktor;


    public Employee(){}

    public Employee(String adSoyad, int maas) { //her employee nesnesinin ad soyad ve maaş değerleri tutuluyor.
        this.adSoyad = adSoyad;
        this.maas = maas;


    }

    //getter ve setter metotlar
    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public Direktor getDirektor() {
        return direktor;
    }

    public void setDirektor(Direktor direktor) {
        this.direktor = direktor;
    }

    //toString metodu
    public String toString() {
        return getAdSoyad()+getMaas()+getDirektor();
    }

    // abstract metodların implementasyonu alt sınıflarda gerçekleştirilecek...
    public abstract int countMaliyet();
    public abstract void bilgiYazdır();


}

