/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class Direktor extends Employee implements Container{

    public int index = 0;

    public Direktor(String adSoyad, int maas){//Direktor classı constructorı

        super(adSoyad,maas);
    }

                                                        // direktor sınıfı içerisinde
    private Employee[] employeeList = new Employee[5]; //direktor'un altında çalışan tüm memur ve direktorler employeelist içersinde tutulacak.

   
    public Iterator iterator() { //Iterator classı tipinde iterator methodu tanımlanarak EmployeeIterator nesnesi döndürülüyor

        return new EmployeeIterator();//bu nesne aracılığıyla hasnext() ve next() metodlarına erişim sağlanacak
    }

    private class EmployeeIterator implements Iterator { // concreteIterator sınıfı iterator interface'ini implement ediyor

        int index;

        @Override
        public boolean hasNext() {//iterate edilen collection'da bir sonraki elemanın varlığını kontrol eden method

            if(index < employeeList.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {//iterate edilen collection'da bir sonraki elemanı döndüren method

            if(this.hasNext()){
                return employeeList[index++];
            }
            return null;
        }
    }

    // Abstract metodların gerçekleştirimi
    @Override
    public void bilgiYazdır() //recursive şekilde iterator kullanarak Employee nesnelerinin bilgilerini yazdırıyor
    {
        System.out.println("ad-soyad direktor:"+getAdSoyad()+" maas:"+getMaas());

        Direktor director= new Direktor(this.getAdSoyad(),this.getMaas());
        director.employeeList = this.employeeList;

        
        Iterator iter = director.iterator();
        while (iter.hasNext()) {
            Employee item = (Employee) iter.next();
            if (item instanceof Employee) {
                ((Employee) item).bilgiYazdır();
            }
        }


    }



    @Override
    public int countMaliyet() {//recursive mantıkla iterator kullanılarak employee nesnelerinin maliyet değerleri hesaplanıyor
        int emp_maliyet = 0;
        int maliyet = 0;
        Direktor director= new Direktor(this.getAdSoyad(),this.getMaas());
        director.employeeList=this.employeeList;
        emp_maliyet=director.getMaas();
        maliyet+=emp_maliyet;

        Iterator iter = director.iterator();

        while (iter.hasNext()) {

            Employee item = (Employee) iter.next();
            if (item instanceof Employee) {
                maliyet += ((Employee) item).countMaliyet();//recursive şekilde çağrılan metottan döndürülen her değer, maliyet değişkenine ekleniyor
            }
        }
        return maliyet;
    }

    public void addEmployee(Employee emp)// hiyerarşik yapıyı oluşturan employee nesnesi ekleme methodu
    {
        employeeList[index] = emp;
        index++;
    }

}


    

