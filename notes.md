POM:
BOM:Bill of Materials

Transitive Vulnerable dependencyler olduğunda dpendency management da vulnerable olmayn versiyon ile ezebiliriz.

### Parent pom da neden spring-boot-starter-parent kullanılmadı?
Çünkü spring-boot-starter-parent, birçok şeyi (plugin versiyonları, default config'ler, encoding vs.) ayarlayan bir Maven parent’tır. _Ama Maven projelerinde sadece bir tane parent tanımlanabilir._

Çok modüllü projelerde genelde kendi parent pom’unu yazarsın (örneğin my-multimodule-project) — ve bu durumda spring-boot-starter-parent’ı doğrudan parent olarak kullanamazsın. Onun yerine spring-boot-dependencies'i dependencyManagement içinde import edersin.

Bu da sana aynı avantajları sağlar: Spring versiyonlarının tek bir yerden yönetilmesi.

🤓 Eğer illa spring-boot-starter-parent kullanmak istersen...
Tek modüllü projelerde kullanılabilir, ama multi-module yapıda şöyle bir şey olur (çok önerilmez):

Alt modüller spring-boot-starter-parent'ı parent olarak alır.

Ortak bir parent tanımlanamaz, yapı karmaşıklaşır.

✨ Önerilen Yaklaşım: Kendi Parent POM + spring-boot-dependencies
Senin yaptığın gibi çok modüllü bir projede ideal yapı şudur:

