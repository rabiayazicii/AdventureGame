# 🎮 Adventure Game - Macera Oyunu
**Java Console OOP**

Metin tabanlı RPG macera oyunu - Java ile SOLID prensiplerine uygun olarak geliştirilmiştir

[![Java](https://img.shields.io/badge/Java-8%2B-orange.svg)](https://www.oracle.com/java/)
[![SOLID](https://img.shields.io/badge/SOLID-Principles-green.svg)](https://en.wikipedia.org/wiki/SOLID)
[![OOP](https://img.shields.io/badge/OOP-Design-blue.svg)](https://en.wikipedia.org/wiki/Object-oriented_programming)

## 📖 Hakkında

Adventure Game, klasik metin tabanlı RPG oyunlarından esinlenilerek geliştirilmiş bir konsol oyunudur. Oyuncular farklı karakterler seçerek çeşitli lokasyonlarda düşmanlarla savaşır, para kazanır, ekipman satın alır ve sonunda tüm ödülleri toplayarak oyunu kazanır.

**Bu proje SOLID prensiplerine uygun olarak tasarlanmıştır ve temiz, modüler kod yapısına sahiptir.**

## ✨ Özellikler

- 🎭 **3 Farklı Karakter**: Her biri benzersiz özellikler ve başlangıç statlarına sahip
- 🗺️ **6 Lokasyon**: Güvenli bölgeler, mağaza ve savaş alanları
- ⚔️ **4 Düşman Türü**: Zombiler, Vampirler, Ayılar ve Yılanlar
- 🛡️ **Ekipman Sistemi**: Silahlar ve zırhlar satın alarak karakterini güçlendir
- 🎁 **Loot Sistemi**: Madende düşmanları yenerek rastgele eşya kazan
- 🏆 **Ödül Sistemi**: 3 farklı ödülü toplayarak oyunu kazan
- 💰 **Ekonomi Sistemi**: Para kazan ve harca
- 🎯 **SOLID Prensipleri**: Temiz, modüler ve genişletilebilir kod yapısı
- 🔧 **Interface Tabanlı**: Loose coupling ve yüksek genişletilebilirlik

## 🎮 Nasıl Oynanır

### Oyun Akışı
1. **Karakter Seçimi**: Oyuna başlarken 3 karakter arasından birini seç
2. **Lokasyon Seçimi**: Ana menüden gitmek istediğin lokasyonu seç
3. **Savaş veya Alışveriş**: Lokasyona göre düşmanlarla savaş veya ekipman satın al
4. **Ödül Toplama**: 
   - **Mağara, Orman, Nehir**: Her birinden bir ödül kazan (Food, Firewood, Water) + Her düşman öldüğünde para kazan
   - **Maden**: Her yılan öldüğünde rastgele loot kazan (silah, zırh, para)
5. **Kazanma**: 3 ana ödülü (Food, Firewood, Water) toplayıp Güvenli Eve döndüğünde oyunu kazanırsın!

### Karakterler

| Karakter | Hasar | Can | Başlangıç Parası | Özellik |
|----------|-------|-----|-------------------|---------|
| 🗡️ **Samurai** | 5 | 21 | 15₺ | Dengeli bir savaşçı |
| 🏹 **Archer** | 7 | 18 | 20₺ | Yüksek hasar, orta can |
| 🛡️ **Knight** | 8 | 24 | 5₺ | Yüksek can ama az para |

### Lokasyonlar

#### 🏠 Güvenli Ev (SafeHome)
- Canını tamamen iyileştirir
- Tüm ödülleri topladıysan burada oyunu kazanırsın!

#### 🏪 Mağaza (ToolStore)
**Silahlar:**
- 🔫 **Tabanca**: +2 Hasar (1₺)
- ⚔️ **Kılıç**: +3 Hasar (35₺)
- 🎯 **Tüfek**: +7 Hasar (45₺)

**Zırhlar:**
- 🥋 **Hafif Zırh**: 1 Blok (15₺)
- 🛡️ **Orta Zırh**: 3 Blok (25₺)
- 🏰 **Ağır Zırh**: 5 Blok (40₺)

#### ⚔️ Savaş Alanları

| Lokasyon | Düşman | Düşman Sayısı | Hasar | Can | Ödül | Para |
|----------|--------|---------------|-------|-----|------|------|
| 🦇 **Mağara** | Zombi | 1-3 (rastgele) | 3 | 10 | 🍖 Food | 4₺ |
| 🌲 **Orman** | Vampir | 1-4 (rastgele) | 4 | 14 | 🪵 Firewood | 7₺ |
| 🌊 **Nehir** | Ayı | 1-5 (rastgele) | 7 | 20 | 💧 Water | 12₺ |
| ⛏️ **Maden** | Yılan | 1-5 (rastgele) | 3-6 (rastgele) | 12 | 🎁 Loot | - |

### 🎁 Özel: Maden Loot Sistemi

**ÖNEMLİ**: Madendeki her yılan ayrı ayrı loot düşürür! (Diğer bölgelerden farklı)

#### 🎲 Loot İhtimalleri
- **%15 İhtimal** - Rastgele Silah
- **%15 İhtimal** - Rastgele Zırh  
- **%25 İhtimal** - Para
- **%45 İhtimal** - Hiçbir şey

#### 🎯 Silah Loot Detayları (%15 içinde)
- **%20 İhtimal**: 🔫 Tabanca (+2 Hasar)
- **%30 İhtimal**: ⚔️ Kılıç (+3 Hasar)
- **%50 İhtimal**: 🎯 Tüfek (+7 Hasar)

#### 🛡️ Zırh Loot Detayları (%15 içinde)
- **%20 İhtimal**: 🏰 Ağır Zırh (5 Blok)
- **%25 İhtimal**: 🛡️ Orta Zırh (3 Blok)
- **%55 İhtimal**: 🥋 Hafif Zırh (1 Blok)

#### 💰 Para Loot Detayları (%25 içinde)
- **%20 İhtimal**: 10₺
- **%30 İhtimal**: 5₺
- **%50 İhtimal**: 1₺

### 🏆 Kazanma Koşulu

Oyunu kazanmak için:

✅ Mağara'yı tamamla → 🍖 **Food** ödülünü kazan  
✅ Orman'ı tamamla → 🪵 **Firewood** ödülünü kazan  
✅ Nehir'i tamamla → 💧 **Water** ödülünü kazan  
✅ 3 ödülle birlikte Güvenli Eve dön  

🎉 **TEBRİKLER! OYUNU KAZANDIN!** 🎉

## 🚀 Kurulum

### Gereksinimler
- ☕ **Java 8** veya üzeri
- 📦 **JDK** yüklü olmalı


## 🎯 Oyun Mekaniği

### Savaş Sistemi

#### ⚔️ Savaş Başlangıcı
- **Düşman Sayısı**: Her bölgede rastgele belirlenir
  - **Mağara**: 1-3 Zombi (3 hasar)
  - **Orman**: 1-4 Vampir (4 hasar)
  - **Nehir**: 1-5 Ayı (7 hasar)
  - **Maden**: 1-5 Yılan (3-6 rastgele hasar)
- **İlk Saldırı**: Random olarak belirlenir (oyuncu veya düşman)
- **Savaş Döngüsü**: Sırayla saldırı yapılır
- **Kaçma**: Her turda "<V>ur veya <K>aç" seçeneği sunulur

#### 💥 Hasar Hesaplama
- **Oyuncu Saldırısı**: `Toplam Hasar = Karakter Hasarı + Silah Hasarı`
- **Düşman Saldırısı**: `Alınan Hasar = Düşman Hasarı - Zırh Bloklaması`
- **Minimum Hasar**: Zırh bloklaması negatif olamaz (minimum 0)

#### 🎯 Özel Durumlar
- **Maden**: Her yılan öldüğünde özel loot sistemi çalışır
- **Diğer Bölgeler**: Her düşman öldüğünde para ödülü verilir
  - **Mağara**: Her Zombi öldüğünde 4₺ para
  - **Orman**: Her Vampir öldüğünde 7₺ para  
  - **Nehir**: Her Ayı öldüğünde 12₺ para
- **Can Kontrolü**: Can 0'a düşerse oyun biter

#### 🎁 Maden Loot Sistemi Detayları
- **Her Yılan**: Ayrı ayrı loot düşürür
- **%15 İhtimal**: Rastgele Silah (Tabanca %20, Kılıç %30, Tüfek %50)
- **%15 İhtimal**: Rastgele Zırh (Ağır %20, Orta %25, Hafif %55)
- **%25 İhtimal**: Para (10₺ %20, 5₺ %30, 1₺ %50)
- **%45 İhtimal**: Hiçbir şey

### Strateji İpuçları
- 💡 **İlk önce para biriktir**: Mağaradan başla, zombiler kolay ve her biri 4₺ para kazandırır
- 💡 **Ekipman al**: Mağazadan silah ve zırh almadan zorlu düşmanlara gitme
- 💡 **Can kontrolü**: Canın azaldıysa Güvenli Eve git ve iyileş
- 💡 **Madeni son bırak**: Maden loot çiftliği için idealdir, güçlendikten sonra git
- 💡 **Zırh öncelikli**: İyi zırh seni uzun süre hayatta tutar
- 💡 **Maden stratejisi**: Her yılan ayrı loot düşürür, bu yüzden madeni tekrar tekrar ziyaret et
- 💡 **Random saldırı**: İlk saldırı random belirlenir, şanslı ol!
- 💡 **Kaçma seçeneği**: Her turda kaçabilirsin, canın azaldıysa kaçmayı düşün
- 💡 **Para çiftliği**: Her düşman öldüğünde para kazanırsın, bu yüzden düşmanları tekrar tekrar öldür
- 💡 **Düşman sayısı**: Her bölgede düşman sayısı rastgele, şanslı olursan az düşmanla karşılaşırsın
- 💡 **Risk yönetimi**: Az düşmanlı bölgeleri tercih et, çok düşmanlı bölgelerden kaç
- 💡 **Yılan hasarı**: Madendeki yılanların hasarı 3-6 arası rastgele, şanslı olursan düşük hasarlı yılanlarla karşılaşırsın

## 🏗️ Mimari

Proje, **SOLID prensipleri** ve **Design Patterns** kullanılarak geliştirilmiştir.

### Klasör Yapısı
```
AdventureGame/
├── src/
│   └── com/
│       └── adventuregame/
│           ├── characters/           # Karakter sınıfları
│           │   ├── Archer.java
│           │   ├── Knight.java
│           │   └── Samurai.java
│           ├── core/                 # Ana oyun mantığı
│           │   ├── Game.java
│           │   └── Main.java
│           ├── entities/             # Temel varlıklar
│           │   ├── GameChar.java
│           │   ├── Obstacle.java
│           │   └── Player.java
│           ├── interfaces/           # Interface'ler (SOLID için)
│           │   ├── IArmor.java
│           │   ├── ICharacter.java
│           │   ├── ICombat.java
│           │   ├── IItem.java
│           │   ├── ILocation.java
│           │   ├── IObstacle.java
│           │   └── IWeapon.java
│           ├── inventory/            # Envanter sistemi
│           │   └── Inventory.java
│           ├── items/                # Eşyalar
│           │   ├── Armor.java
│           │   └── Weapon.java
│           ├── locations/            # Bölgeler
│           │   ├── BattleLoc.java
│           │   ├── Cave.java
│           │   ├── Forest.java
│           │   ├── Location.java
│           │   ├── Maden.java
│           │   ├── NormalLoc.java
│           │   ├── River.java
│           │   ├── SafeHome.java
│           │   └── ToolStore.java
│           ├── obstacles/            # Düşmanlar
│           │   ├── Bear.java
│           │   ├── Snake.java
│           │   ├── Vampire.java
│           │   └── Zombie.java
│           └── services/             # Servisler
│               └── CombatService.java
└── README.md
```

### SOLID Prensipleri Uygulaması

#### 🎯 **Single Responsibility Principle (SRP)**
- Her sınıf tek sorumluluğa sahip
- `CombatService`: Sadece savaş mantığı
- `Inventory`: Sadece envanter yönetimi
- `Player`: Sadece oyuncu bilgileri

#### 🔄 **Open/Closed Principle (OCP)**
- Yeni karakterler eklemek için `ICharacter` interface'ini implement et
- Yeni düşmanlar eklemek için `IObstacle` interface'ini implement et
- Yeni bölgeler eklemek için `ILocation` interface'ini implement et

#### 🔀 **Liskov Substitution Principle (LSP)**
- Tüm karakterler `GameChar` yerine geçebilir
- Tüm düşmanlar `Obstacle` yerine geçebilir
- Tüm bölgeler `Location` yerine geçebilir

#### 🔌 **Interface Segregation Principle (ISP)**
- Küçük, özelleşmiş interface'ler
- `IWeapon`, `IArmor`, `ICombat` gibi spesifik interface'ler

#### 🔗 **Dependency Inversion Principle (DIP)**
- Soyutlamalara bağımlılık
- Interface'ler üzerinden çalışma

## 🎨 Ekran Görüntüleri

### Karakter Seçimi
```
═════════════════════════════════
🎮 Macera Oyununa Hoşgeldiniz!
Lütfen bir isim giriniz: Oyuncu
✨ Oyuncu, bu karanlık ve sisli adaya hoşgeldiniz!
⚠️ Burada yaşananların hepsi gerçek!
Lütfen bir karakter seçiniz:
📜 Karakterler:
ID: 1 | Karakter: Samurai | ⚔️ Hasar: 5 | ❤️ Sağlık: 21 | 💰 Para: 15
ID: 2 | Karakter: Archer | ⚔️ Hasar: 7 | ❤️ Sağlık: 18 | 💰 Para: 20
ID: 3 | Karakter: Knight | ⚔️ Hasar: 8 | ❤️ Sağlık: 24 | 💰 Para: 5
Lütfen karakterinizi seçiniz (ID giriniz): 
```

### Lokasyon Menüsü
```
═════════════════════════════════
📍 Bölgeler:
1 - 🏠 Güvenli Ev       --> Canınız yenilenir
2 - 🏪 Mağaza           --> Silah ve zırh satın al
3 - 🦇 Mağara           --> Ödül: 🍖 Food | Düşman: Zombi
4 - 🌲 Orman            --> Ödül: 🪵 Firewood | Düşman: Vampir
5 - 🌊 Nehir            --> Ödül: 💧 Water | Düşman: Ayı
6 - ⛏️ Maden             --> Ödül: 🎁 Loot | Düşman: Yılan
0 - ❌ ÇIKIŞ             --> Oyundan çık
Lütfen gitmek istediğiniz bölgeyi seçiniz: 
```

### Savaş Ekranı
```
═════════════════════════════════
👾 1. Zombi Değerleri
═════════════════════════════════
❤️ Sağlık: 10
⚔️ Hasar: 3
💰 Ödül: 4 ₺
═════════════════════════════════
🍀 Şans sizden yana! İlk hamleyi siz yapıyorsunuz!
-----------------------------------------
<V>ur veya <K>aç
💥 Siz vurdunuz !!
❤️ Canınız: 21
👾 Zombi Canı: 7
```

## 👨‍💻 Geliştirici

**Rabia Yazıcı**

**Made with ☕ and Java**
