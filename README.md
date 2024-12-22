# Cowmam's Clinic Management System 🏥
Sistem Manajemen Klinik sederhana menggunakan Java Swing

## 👥 Developers
- Ahmad Qayyim (202110370311286)
- Moh. Khairul Umam (202110370311448)

## 📝 Deskripsi Project
Cowmam's Clinic Management System adalah aplikasi desktop yang dirancang untuk membantu manajemen data pasien dan dokter di klinik. Aplikasi ini dibuat menggunakan Java Swing dengan fitur-fitur utama seperti:
- Manajemen data pasien
- Manajemen jadwal dokter
- Antarmuka yang user-friendly
- Penyimpanan data menggunakan file handling

## 🛠️ Teknologi yang Digunakan
- Java
- Java Swing untuk GUI
- JUnit untuk testing
- Maven untuk manajemen proyek
- File handling untuk penyimpanan data

## 📁 Struktur Project

LATIHANPUSH
├── src
│   └── main
│       └── java
│           └── hospital
│               ├── Main.java
│               ├── exception
│               │   └── ValidationException.java
│               ├── gui
│               │   ├── MainFrame.java
│               │   ├── PatientPanel.java
│               │   └── DoctorPanel.java
│               ├── model
│               │   ├── Patient.java
│               │   └── Doctor.java
│               ├── service
│               │   ├── PatientService.java
│               │   └── DoctorService.java
│               └── test
│                   ├── PatientTest.java
│                   ├── DoctorTest.java
│                   └── TestRunner.java

## ⚙️ Fitur Utama
1. **Manajemen Pasien**
   - Pendaftaran pasien baru
   - Melihat daftar pasien
   - Pencarian data pasien
   - Validasi input data

2. **Manajemen Dokter**
   - Pendaftaran dokter baru
   - Penjadwalan dokter
   - Pencarian data dokter
   - Validasi jadwal dan data dokter

3. **Fitur Tambahan**
   - Exception handling untuk validasi input
   - Penyimpanan data ke file
   - Interface yang intuitif
   - Sistem pencarian data

## 🔍 Implementasi Clean Code
1. **SOLID Principles**
   - Single Responsibility Principle: Setiap class memiliki satu tanggung jawab
   - Open/Closed Principle: Mudah untuk ditambahkan fitur baru
   - Interface Segregation: Pemisahan interface yang spesifik

2. **Design Patterns**
   - MVC Pattern (Model-View-Controller)
   - Service Pattern untuk logika bisnis
   - Factory Pattern untuk pembuatan objek

## 📝 Dokumentasi Kode
### Package Structure
1. **exception**
   - ValidationException: Menangani error validasi input

2. **model**
   - Patient: Model untuk data pasien
   - Doctor: Model untuk data dokter

3. **service**
   - PatientService: Layanan untuk manajemen data pasien
   - DoctorService: Layanan untuk manajemen data dokter

4. **gui**
   - MainFrame: Frame utama aplikasi
   - PatientPanel: Panel untuk manajemen pasien
   - DoctorPanel: Panel untuk manajemen dokter

## 🧪 Testing
- Unit testing menggunakan JUnit
- Test coverage untuk model dan service layer
- Validasi input dan business logic testing

## 📥 Cara Menjalankan Aplikasi
1. Clone repository ini
2. Pastikan Java 11 dan Maven terinstall
3. Jalankan perintah: `mvn clean install`
4. Jalankan aplikasi melalui Main.java

## 🔄 Update & Maintenance
- Regular bug fixes
- Penambahan fitur baru
- Optimasi performa
- Unit testing untuk fitur baru

## 🤝 Kontribusi
Proyek ini merupakan tugas akhir praktikum Pemrograman Lanjut. Kontribusi dan saran sangat diterima untuk pengembangan lebih lanjut.

## 📄 Lisensi
© 2024 Ahmad Qayyim & Moh. Khairul Umam - Informatika UMM

---
*Dibuat dengan ❤️ untuk UAP Pemrograman Lanjut*