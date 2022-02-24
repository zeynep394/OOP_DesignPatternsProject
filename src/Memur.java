/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public  class Memur extends Employee {

    public Memur(String adSoyad, int maas){

        super(adSoyad,maas);
    }


    @Override
    public int countMaliyet() {//memur nesnelerinin maliyeti kendi maaş değerleri olduğu için maaş değeri döndürülüyor
        return getMaas();

    }

    @Override
    public void bilgiYazdır() {//memur nesnelerinin ad soyad ve maaş bilgileri yazdırılıyor

        System.out.println("ad-soyad memur:"+getAdSoyad()+" maas:"+getMaas());
    }
}

    
