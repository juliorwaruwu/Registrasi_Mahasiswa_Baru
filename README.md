SISTEM REGISTRASI MAHASISWA
===========================================

DESKRIPSI PROJECT
-------------------------------------------
Sistem Registrasi Mahasiswa adalah aplikasi berbasis Spring Boot
yang digunakan untuk melakukan pendaftaran calon mahasiswa secara online.

Fitur utama:
- Registrasi mahasiswa
- Login admin
- Dashboard admin
- Search mahasiswa
- Filter mahasiswa
- Verifikasi mahasiswa
- Validasi data
- Captcha generator

===========================================

TEKNOLOGI YANG DIGUNAKAN
-------------------------------------------

BACKEND
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Hibernate Validation

FRONTEND
- HTML
- CSS
- JavaScript
- Thymeleaf

DATABASE
- MySQL

===========================================

FITUR APLIKASI
-------------------------------------------

1. REGISTRASI MAHASISWA
Mahasiswa dapat mengisi:
- Nama lengkap
- NIM
- Email
- Nomor HP
- Tanggal lahir
- Program studi
- Alamat
- Asal sekolah
- Captcha

2. VALIDASI DATA
Sistem melakukan validasi:
- Nama minimal 4 karakter
- NIM 10 digit angka
- Email valid
- Nomor HP valid
- Alamat minimal 15 karakter
- Umur minimal 18 tahun
- Email tidak boleh duplicate
- NIM tidak boleh duplicate

3. LOGIN ADMIN
Username : admin
Password : admin123

4. DASHBOARD ADMIN
Admin dapat:
- Melihat total pendaftar
- Melihat total pending
- Melihat total verified
- Melihat seluruh data mahasiswa
- Search mahasiswa
- Filter mahasiswa
- Verifikasi mahasiswa
- Reject mahasiswa

5. SEARCH & FILTER
Filter berdasarkan:
- Nama
- NIM
- Status
- Program Studi

6. VERIFIKASI
Admin dapat:
- Mengubah status menjadi VERIFIED
- Mengubah status menjadi REJECTED

===========================================

PERSIAPAN INSTALL
-------------------------------------------

Pastikan sudah menginstall:
- Java JDK 17+
- Maven
- MySQL
- IntelliJ IDEA / VS Code / STS

Cek Java:
java -version

Cek Maven:
mvn -version

===========================================

CARA INSTALL PROJECT
-------------------------------------------

1. Clone Repository

git clone https://github.com/username/project-name.git

2. Masuk ke Folder Project

cd project-name

3. Buat Database MySQL

CREATE DATABASE registrasi_db;

4. Konfigurasi application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/registrasi_db
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

5. Install Dependency

mvn clean install

6. Jalankan Project

mvn spring-boot:run

atau jalankan:
RegistrationApplication.java

===========================================

URL APLIKASI
-------------------------------------------

Halaman Registrasi
http://localhost:8080/

Login Admin
http://localhost:8080/login

Dashboard Admin
http://localhost:8080/admin/dashboard

===========================================

ALUR PENGGUNAAN
-------------------------------------------

MAHASISWA
1. Buka halaman registrasi
2. Isi form
3. Submit form
4. Data tersimpan
5. Halaman success muncul

ADMIN
1. Login admin
2. Masuk dashboard
3. Lihat daftar mahasiswa
4. Search/filter mahasiswa
5. Klik verifikasi
6. Ubah status
7. Data otomatis update

===========================================

ENTITY MAHASISWA
-------------------------------------------

private Long id;
private String nama;
private String nim;
private String email;
private String nomorHp;
private LocalDate tanggalLahir;
private String alamat;
private String prodi;
private String asalSekolah;
private LocalDate tanggalDaftar;
private String status;

===========================================

STATUS MAHASISWA
-------------------------------------------

PENDING
= Menunggu verifikasi admin

VERIFIED
= Data telah diverifikasi

REJECTED
= Data ditolak

===========================================

SECURITY
-------------------------------------------

Menggunakan:
- Spring Security
- Authentication Login
- Session Management
- Protected Route Admin

===========================================

CAPTCHA
-------------------------------------------

Captcha dibuat menggunakan JavaScript:
- Generate random otomatis
- Bisa refresh
- Berbeda setiap reload halaman

===========================================

Fitur Unik
-------------------------------------------
Analystic
- Chart Status Mahasiswa
- chart count by prody
- search bar on the top of the table list mahasiswa
- no registrasi yang otomatis dalam tabel
  
===========================================

AUTHOR
-------------------------------------------

Developed by:
Julior Putra Waruwu

Infromation Technology Student

