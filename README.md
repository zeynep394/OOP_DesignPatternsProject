**1.UML Sınıf Diyagramı**

Projenin gerçekleştirim aşamasında kullanılan sınıflar, nesneye yönelik
programlama yaklaşımları ve tasarım desenleri Şekil 1’de yer almaktadır.

Şekil 1’de tüm uygulamaya ait UML sınıf diyagramı yer almaktadır.

![](media/image1.png){width="7.058333333333334in"
height="4.941666666666666in"}

**Şekil 1.** Uygulama UML Sınıf Diyagramı.

**2.Sınıfların Açıklamaları ve Kullanılan Nesneye Dayalı Programlama
Yaklaşımları**

Proje kapsamında oluşturulması istenen hiyerarşik yapı composite pattern
kullanılarak gerçekleştirilmiştir. Composite pattern gerçekleştirimi
için Employee, Memur ve Direktor sınıfları tanımlanmıştır.

> **2.1 Employee Sınıfı**
>
> Employee sınıfı abstract class olarak tanımlanmıştır. Bu sınıftan
> kalıtım yoluyla Memur ve Direktor sınıfları türetilmiştir. Bu sınıfta
> private değişkenler olarak çalışanların ad-soyad ve maaş bilgileri,
> ayrıca Direktor sınıfı tipinde bir direktör nesnesi de yer almaktadır.
> Private değişkenler için gerekli olan getter ve setter metodlar ve
> bunun yanında çalışanın maliyetini hesaplayan abstract countMaliyet ve
> çalışanın bilgilerini yazdıran abstract bilgiYazdır metodu yer
> almaktadır. Abstract metodların gerçekleştirimi alt sınıflar olan
> Memur ve Direktor sınıflarında her bir sınıf özelinde yapılmaktadır.
>
> **2.2 Memur Sınıfı**
>
> Kalıtım yolu ile Emplooye sınıfından türetilmiştir. Memur tipindeki
> çalışanlar için oluşturulacak nesneler bu sınıftan yaratılır. Memur
> sınıfı Employee sınıfının constructor metodunu miras alır. Ayrıca
> Employee sınıfında tanımlanan countMaliyet ve bilgiYazdır abstract
> metodların memur nesnesi için gerçekleştirimi bu sınıfta
> yapılmaktadır.
>
> **2.3 Direktor Sınıfı**
>
> Kalıtım yoluyla Employee sınıfından türetilmiştir. Direktör tipindeki
> çalışanlara ait nesneler bu sınıftan yaratılmaktadır. Bu sınıf
> İçerisinde direktörlerin ve bu direktörlerin altında çalışan
> employee’lerin (employee direktör veya memur olabilmektedir) bulunduğu
> dizi tipinde employeeList\[\] koleksiyonu ve bu koleksiyona
> eleman(employee nesnesi) eklemeyi sağlayan addEmployee() metodu yer
> almaktadır. Dizi tipinde olan koleksiyonu dolaşmak için iterator
> tasarım deseni kullanılmış ve bu tasarım deseninin gerçekleştirimi
> için Container arayüzü, Iterator arayüzü ve Iterator arayüzünü
> implement eden EmployeeIterator sınıfı oluşturulmuştur.
>
> Direktor sınıfı Container arayüzünü implemet etmekte ve Container
> içerisinde tanımlanmış olan iterator() metodunu gerçekleştirmektedir.
> Ayrıca Iterator arayüzü içerisinde tanımlanmış olan hasNext() ve
> next() metodlarının gerçekleştirimi de yardımcı sınıf olan
> EmployeeIterator içerisinde yapılmaktadır. Direktör tipindeki
> çalışanlar için gerçekleştirimi yapılmaktadır.
>
> Koleksiyon üzerinde dolaşmayı sağlamak için iterator tasarım deseni
> kullanılmıştır. İterator tasarım deseninin gerçekleştirimi için
> Container arayüzü, Iterator arayüzü, Direktor sınıfı ve Direktor
> sınıfı içerisindeki EmployeeIterator yardımcı sınıfı kullanılmıştır.
>
> **2.4 Container Arayüzü**
>
> Container arayüzü içerisinde Iterator dönüş tipinde iterator() metodu
> tanımlanmıştır. (Metodun gerçekleştirimi Container arayüzünü implement
> eden Direktor sınıfı içerisinde yapılmaktadır. )
>
> **2.5 Iterator Arayüzü**
>
> Iterator arayüzü içerisinde hasNext() ve next() metodları
> tanımlanmıştır.(Bu metodların gerçekleştirimi Direktor sınıfı
> içerisinde yer alan EmployeeIterator yardımcı sınıfı içerisinde
> yapılmaktadır.)
>
> İterator tasarım deseni gerçekleştirimi için kullanılan Direktor
> sınıfı ile ilgili gerekli açıklamalar 2.3 bölümünde yer almaktadır.
>
> **2.6 EmployeeIterator Yardımcı Sınıfı**
>
> Employee Iterator yardımcı sınıfı Direktor sınıfı içerisinde yer
> almaktadır. Direktor sınıfı içerisinde oluşturulan dizi tipindeki
> employeeList koleksiyonunu dolaşmayı sağlayan ve Iterator arayüzünde
> tanımlanmış olan hasNext() ve next() metodlarının gerçekleştirimini
> yapılmaktadır.
>
> Proje kapsamında verilerin farklı dosyalardan okunabileceği durumlar
> için gerekli esnekliği sağlamak amacıyla factory tasarım deseni
> kullanılmıştır. Bu tasarım deseninin gerçekleştirimi ise FileClass
> arayüzü, FileFactory ve Txt sınıfları ile sağlanmıştır. Factory
> tasarım deseni, bu desenin gerçekleştirimi sırasında kullanılan
> sınıflar ve Deneme sınıfı hakkında gerekli açıklamalar bölüm 4.1’de
> yer almaktadır.

**3 JUnit Birim Test Gerçekleştirimi**

Birim test, bir sınıf veya o sınıfın herhangi bir metodu gibi yazılımın
en küçük parçasının davranışlarını kontrol etmektir. Bu program
kapsamında Memur sınıfı JUnit kullanarak birim testlere dayalı şekilde
geliştirilmiştir. Bu birim testi gerçekleştirmek amacıyla öncelikle
çalışmayan, hatta derlenmeyen küçük bir test yazılmış, sonra sadece
yazılan testi geçecek kadar kodlama yapılarak testin başarılı olması
sağlanmıştır.

JUnit’te asıl test etmek istenen metot, @ işareti ile gösterilmektedir.
Program kapsamında Memur sınıfı içerisinden asıl test edilmek istenen
CountMaliyet ve bilgiYazdır isimli iki metot vardır. CountMaliyet ve
bilgiYazdır metotları kullanılarak test metotlarının içinde beklenen
davranışın doğrulanması için çağırılan önermeler oluşturulmuştur.
Bunlara ait ekran görüntüleri şekil2 ve şekil3’te yer almaktadır.

![](media/image2.png){width="3.1166666666666667in"
height="1.2416666666666667in"}![](media/image3.png){width="3.125in"
height="1.2166666666666666in"}

**Şekil 2.** testCountMaliyet metodu. **Şekil 3.** testBilgiYazdır
metodu.

Herhangi bir nesne için beklenen değer ve gerçekte var olan değerin
eşitliği assertEquals metodu ile karşılaştırılarak CountMaliyet metodunu
test etmek amacıyla ad soyad sahası Emre Kosar, maaş sahası 700 olan bir
memur nesnesi tanımlanmıştır. Bu nesne üzerinden countMaliyet metodu
çağrıldığında beklenen çıktı, maliyet değerinin 700 olmasıdır.
assertEquals metodunun çıktısı ‘doğru’ ise test başarılıdır ‘yanlış’ ise
testin başarısız olması beklenmektedir.

NOT: Bu Proje Java with Ant olarak oluşturulduğu için Junit test
çalıştırılırken sorunla karşılaşıldı.Bu sebeple Junit ile
gerçekleştirilen MemurTest sınıfını Maven ile proje oluşturularak
NesneProjeMaven içerisinde birim test gerçekleştirildi ve çalıştırıldı.
Birim testler başarı ile sonuçlandı ve tüm testler geçildi.

Şekil4’te MemurTest sınıfının çalıştırılması sonucu elde edilen test
sonucuna ait ekran görüntüsü yer almaktadır.

![](media/image4.png){width="6.3in" height="4.183333333333334in"}

**Şekil4**.Test sonucu.

**4 Veri Erişim Yapısı Esnekliği ve Factory Tasarım Deseni**

> **4.1 Factory Tasarım Deseni**
>
> Verilen proje kapsamında main metodunun bulunduğu deneme sınıfını
> yazarken ilgili girdiler bir txt dosyasından okunmuştur. Ancak
> girdilerin veritabanları, xml dosyaları gibi farklı kaynaklardan da
> okunmasını gerektiren durumlar olabilirdi. Bu konudaki gerekli
> esnekliği sağlamak için, Factory tasarım deseni kullanıldı.
>
> Fabrika tasarım deseni, bir nesneyi kullanıcılardan bağımsız olarak
> yaratmamıza olanak verir. Nesne yaratma işlemi Factory sınıfına
> taşınır bu sayede hangi sınıftan nesne yaratılacağını, alt sınıfların
> belirlemesisağlanır.\
> Veri erişim yapılarını esnek hale getirmekteki hedefimiz, kullanıcının
> verinin alındığı yerden bağımsız olarak elde edilen veriyi program
> kapsamında kullanabilmesini sağlamaktır. Yani veriyi nereden alırsak
> alalım main metodunda işlenecek veri tipi hep aynı olacaktır ve aynı
> zamanda bu metot içerisinde farklı veri erişim yapılarına yönelik
> kodların kullanılmasına gerek kalmayarak sadeleşmeye gidilmesi
> amaçlanmıştır.
>
> Tüm bu gereksinimler göz önünde bulundurulduğunda Factroy tasarım
> deseninin, gerçekleştirmek istediğimiz esnekliğe yönelik en kapsamlı
> tasarım deseni olduğuna karar verilerek veri erişim yapılarına göre
> düzenlenen Factory tasarım deseni, hiyerarşik yapıyı oluşturmak üzere
> yazılan kodlar ile entegre edildi.
>
> **4.2 Factory Tasarım Deseni UML Diyagramı\
> \
> **
>
> ![](media/image5.png){width="3.7416666666666667in"
> height="4.741666666666666in"}
>
> **Şekil5:** Factory UML diagramı
>
> UML diyagramında da görüleceği üzere yazdığımız kodları Factory
> tasarım deseni çerçevesinde oluştururken FileClass isimli ara yüzden
> yararlandık. Bu ara yüz içerisinde, veri çekmek için kullanılacak her
> bir veri erişim yapısı tarafından özel olarak gerçekleştirilen ve
> String veri tipinde bir ArrayList döndüren oku() isimli abstract metot
> oluşturuldu. Bu metodun tanımı, FileClass ara yüzünü implement eden
> alt sınıflar tarafından yapılır. Veri erişim mekanizmasını sağlayan
> her bir alt sınıf, öncelikle oku() metodunu kendi gereksinimleri
> çerçevesinde oluşturur daha sonra elde edilen veri, String tipinde bir
> ArrayList içerisinde tutulur bu ArrayList oku() metodu tarafından
> döndürülür. FileFactory sınıfı içerisinde, kullanıcı tarafından
> belirtilen nesnelerin yaratılmasını gerçekleştiren getFile() metodu
> bulunur. Bu metot istenilen tipteki nesneyi oluşturur ve döndürür.
>
> Main metot içerisinde FileFactory kullanılarak istenilen tipte nesne
> oluşturulur ve bu nesne üzerinden oku() metodunun çağırımı
> gerçekleştirilir. oku() metodunun döndürdüğü ArrayList main metodu
> içerisinde hiyerarşik yapının oluşturulması için kullanılır.
>
> **4.3 Program Kaynak Kodları**
>
> FileClass ara yüzünde alt sınıflar tarafından gerçekleştirilecek ve
> String tipinde bir ArrayList döndüren oku metodu tanımlanıyor.
>
> ![](media/image6.png){width="6.458333333333333in" height="0.6in"}
>
> Şekil 6: FileClass ara yüzü
>
> Txt sınıfı FileClass ara yüzünü implement eden bir alt sınıftır ve bu
> sınıf içerisinde oku metodu txt sınıfının gereksinimlerine göre
> gerçekleştirilir. Txt sınıfı bir veri erişim sınıfıdır ve bu kapsamda
> yapılan işlem bir txt dosyasından verilerin okunup döngü aracılığıyla
> result isimli ArrayListe eklenmesi işlemidir.
>
> ![](media/image7.png){width="4.941666666666666in" height="2.625in"}
>
> **Şekil 7:** Txt sınıfı
>
> FileFactory sınıfı içerisinde hangi alt sınıftan nesne
> oluşturulacağını belirleyen getFile() metodu tanımlanmıştır.
> Programımız kapsamında bu örnek üzerinde yalnızca TXT dosyalarından
> veri okuma işlemi gerçekleştirildiği için yalnızca TXT alt sınıfı
> oluşturuldu ancak Factory tasarım deseni sayesinde kod üzerinde bir
> değişikliğe gidilmeden veritabanından veya bir XML dosyasından da
> kolayca veri erişimi gerçekleştirilebilirdi.
>
> ![](media/image8.png){width="6.358333333333333in"
> height="1.9166666666666667in"}
>
> **Şekil 8**: FileFactory sınıfı
>
> Main metodu içerisinde ise öncelikle arka plandaki nesne oluşturma
> mantığı kullanıcıya gösterilmeden TXT tipinde bir FileFactory nesnesi
> oluşturulur. Bu nesne üzerinden TXT sınıfının metotlarına erişim
> gerçekleştirilebilir ve oku metodunun çağırımı yapılır. Oku() metodu
> tarafından döndürülen String ArrayList’i data isimli ArrayList’te
> tutulur ve bir while döngüsü aracılığıyla hiyerarşik yapının
> oluşturulması için kullanılır.
>
> ![](media/image9.png){width="6.433333333333334in"
> height="2.466666666666667in"}
>
> **Şekil 9:**Deneme sınıfı main metodu.
