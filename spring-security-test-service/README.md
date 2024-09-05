# spring-security-config vs  spring-boot-starter-security
spring-security-config ve spring-boot-starter-security kütüphaneleri, Spring Security ile ilgili farklı özellikleri ve yapılandırmaları içeren iki farklı bağımlılıktır.

- __spring-security-config__:
spring-security-config kütüphanesi, Spring Security'nin yapılandırma ve genel özelliklerini sağlar. Bu kütüphane, Spring Security'nin yapılandırma sınıflarını, güvenlik filtrelerini ve diğer yardımcı sınıfları içerir. Özellikle, WebSecurityConfigurerAdapter sınıfı gibi yapılandırma sınıflarını uygulamak ve Spring Security ayarlarını özelleştirmek için kullanılır.


- __spring-boot-starter-security__:
spring-boot-starter-security bağımlılığı, Spring Boot projelerinde Spring Security'nin entegrasyonunu kolaylaştırmak için tasarlanmıştır. Bu bağımlılık, Spring Security ve Spring Boot'u bir araya getirerek güvenlik konfigürasyonunun otomatik olarak yapılandırılmasını sağlar. Bu sayede, güvenliği ayarlamak için ek yapılandırma sınıfları yazmanıza gerek kalmadan temel güvenlik önlemlerini alabilirsiniz. Önceden tanımlanmış bir kullanıcı adı ve şifre ile basit bir kimlik doğrulama yapılandırması da dahil olmak üzere birçok varsayılan güvenlik özelliği sunar.
spring-boot-starter-security bağımlılığı, spring-security-config kütüphanesini de içerir, bu nedenle genel olarak Spring Security'nin temel işlevlerini kullanmak için spring-boot-starter-security bağımlılığı yeterlidir. Ancak, daha karmaşık yapılandırmalar veya özelleştirmeler yapmanız gerekiyorsa, doğrudan spring-security-config kütüphanesini de ekleyebilir ve daha fazla kontrole sahip olabilirsiniz.
Özet olarak, spring-security-config kütüphanesi Spring Security yapılandırma ve genel özelliklerini sağlarken, spring-boot-starter-security bağımlılığı Spring Security'nin Spring Boot ile entegrasyonunu kolaylaştırır ve temel güvenlik önlemlerini otomatik olarak yapılandırır.