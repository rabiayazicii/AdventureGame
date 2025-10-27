# Macera Oyunu - SOLID Prensiplerine Uygun Refactoring

Bu proje, Java ile yazılmış bir macera oyununun SOLID prensiplerine uygun hale getirilmiş versiyonudur.

## 🎯 SOLID Prensipleri Uygulaması

### 1. Single Responsibility Principle (SRP)
Her sınıfın tek bir sorumluluğu vardır:

- **Player**: Sadece oyuncu bilgilerini yönetir
- **CombatService**: Sadece savaş mantığını içerir
- **AwardService**: Sadece ödül verme işlevlerini içerir
- **UIService**: Sadece kullanıcı arayüzü işlevlerini içerir
- **Location sınıfları**: Her biri sadece kendi bölgesinin işlevlerini içerir

### 2. Open/Closed Principle (OCP)
Sistem genişlemeye açık, değişikliğe kapalı:

- **Maden sınıfı**: Özel ödül sistemi için genişletilebilir
- **Interface'ler**: Yeni karakterler, engeller ve eşyalar eklenebilir
- **AwardService**: Yeni ödül türleri eklenebilir

### 3. Liskov Substitution Principle (LSP)
Alt sınıflar üst sınıfları yerine geçebilir:

- **GameChar alt sınıfları**: Samurai, Archer, Knight
- **Obstacle alt sınıfları**: Zombie, Vampire, Bear, Snake
- **Location alt sınıfları**: BattleLoc, NormalLoc

### 4. Interface Segregation Principle (ISP)
Küçük ve spesifik interface'ler:

- **ICharacter**: Sadece karakter özellikleri
- **IObstacle**: Sadece engel özellikleri
- **ICombat**: Sadece savaş işlevleri
- **IAward**: Sadece ödül işlevleri
- **IWeapon/IArmor**: Sadece eşya özellikleri

### 5. Dependency Inversion Principle (DIP)
Soyutlamalara bağımlılık:

- **Game sınıfı**: Interface'lere bağımlı
- **CombatService**: IObstacle interface'ine bağımlı
- **AwardService**: Player entity'sine bağımlı

## 📁 Paket Yapısı

```
com.adventuregame/
├── core/           # Ana oyun mantığı
├── entities/       # Temel varlıklar
├── interfaces/     # Interface tanımları
├── services/       # İş mantığı servisleri
├── locations/      # Bölge sınıfları
├── characters/     # Karakter sınıfları
├── obstacles/      # Engel sınıfları
├── items/          # Eşya sınıfları
├── inventory/      # Envanter yönetimi
├── awards/         # Ödül sistemi
├── combat/         # Savaş sistemi
└── ui/             # Kullanıcı arayüzü
```

## 🚀 Çalıştırma

```bash
# Projeyi derle
javac com/adventuregame/core/Main.java

# Çalıştır
java com.adventuregame.core.Main
```

## ✨ Refactoring Faydaları

1. **Bakım Kolaylığı**: Her sınıfın tek sorumluluğu olduğu için değişiklikler izole edilir
2. **Genişletilebilirlik**: Yeni özellikler mevcut kodu bozmadan eklenebilir
3. **Test Edilebilirlik**: Her sınıf bağımsız olarak test edilebilir
4. **Kod Kalitesi**: Interface'ler sayesinde daha temiz ve anlaşılır kod
5. **Esneklik**: Dependency injection sayesinde farklı implementasyonlar kullanılabilir

## 🎮 Oyun Özellikleri

- 3 farklı karakter seçeneği (Samurai, Archer, Knight)
- 6 farklı bölge (Güvenli Ev, Mağaza, Mağara, Orman, Nehir, Maden)
- 4 farklı düşman türü (Zombie, Vampire, Bear, Snake)
- Silah ve zırh sistemi
- Ödül sistemi
- Savaş mekaniği

Bu refactoring ile kod daha sürdürülebilir, genişletilebilir ve test edilebilir hale gelmiştir.
