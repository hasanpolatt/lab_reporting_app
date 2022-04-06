# Laboratuvar Raporlama Uygulaması /Türkçe
## Proje Hakkında
Bu projede Spring, Thymeleaf, JPA, Maven, Bootstrap ve veritabanı için H2 teknolojileri kullanılarak basit bir laboratuvar raporlama uygulaması oluşturulmuştur.

Raporda dosya numarası, hasta adı ve soyadı, hasta kimlik
numarası, koyulan tanı başlığı, tanı detayları ve raporun verildiği
tarih yer almaktadır. Belirtilen raporu düzenleme, silme ve inceleme işlemleri yapılabilmektedir. Ayrıca raporlar tarihe göre soralama yapılabilmektedir.

## Nasıl Çalışır
### Çalıştırmadan Önce
Belirli GitHub bağlantısından `git clone` komutuyla proje kopyasını istediğiniz dizine yapıştırabilirsiniz.
Daha sonra sadece kodların çalışabilir hale gelmesi için Java JDK Version 17'nin projeye dahil edilmesi gerekir. Bunun dışında tüm gereklilikler ve teknolojiler `pom.xml` adlı dosyada bulunuyor. Böylece ekstra bir şey kurmaya gerek olmaz.
### Çalıştırdıktan Sonra
Proje çalıştırıldıktan sonra http://localhost:8080/hospital/listReports/ASC adresine gidilerek projenin arayüzüne ulaşılabilir.

## Projenin Ekran Görüntüleri
![Image](https://i.hizliresim.com/c5d2ln3.JPG)
![Image](https://i.hizliresim.com/itkfh4m.JPG)



# Laboratory Reporting Application /English
## About Project
In this project, a simple laboratory reporting application was created using  Spring, Thymeleaf, JPA, Maven, Bootstrap and H2 technologies for the database.

The report includes the file number, patient name and surname, patient ID in the report
number, diagnosis title, diagnosis details and report date. It is possible to edit, delete and review the specified report. In addition, reports can be sorted by date.

## How To Run
### Before Run
You can paste the project copy in any directory with the `git clone` command from the specific GitHub link.
Then only the Java JDK Version 17 needs to be included in the project for the codes to become executable. Apart from that, all the requirements and technologies are in the file named `pom.xml`. So there is no need to install anything extra.
### After Run
`After the project is run, the interface of the project can be accessed by going to http://localhost:8080/hospital/listReports/ASC.`
