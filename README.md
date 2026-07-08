# DailySolve 📱

## Dokumentasi Teknis Aplikasi Android

---

# a. Deskripsi Aplikasi

## Nama Aplikasi
**DailySolve**

## Latar Belakang

Dalam kehidupan sehari-hari, setiap individu memiliki berbagai aktivitas yang dilakukan, seperti olahraga, belajar, pekerjaan, organisasi, hobi, maupun kegiatan sosial. Namun, aktivitas yang dilakukan sering kali tidak tercatat dengan baik sehingga pengguna kesulitan untuk melihat kembali riwayat kegiatan yang telah dilakukan.

DailySolve merupakan aplikasi berbasis Android yang dirancang untuk membantu pengguna dalam mencatat, mengelola, dan memantau aktivitas sehari-hari secara digital. Pengguna dapat menambahkan aktivitas, memberikan kategori, melihat detail aktivitas, memperbarui data aktivitas, serta menghapus aktivitas yang sudah tidak diperlukan.

Dengan adanya aplikasi ini, pengguna dapat mengatur aktivitas harian menjadi lebih terstruktur dan membantu meningkatkan produktivitas.

---

## Tujuan Solusi

Tujuan dibuatnya aplikasi DailySolve yaitu:

1. Membantu pengguna mencatat aktivitas sehari-hari secara digital.
2. Mempermudah pengguna dalam mengelola berbagai kegiatan berdasarkan kategori.
3. Membantu pengguna melihat riwayat aktivitas yang telah dilakukan.
4. Membantu pengguna mengatur kegiatan agar lebih terorganisir.
5. Menyediakan sistem manajemen aktivitas dengan fitur CRUD (Create, Read, Update, Delete).

---

# b. Daftar Fitur

## 1. Register Akun

Fitur yang digunakan pengguna untuk membuat akun baru.

Data yang dimasukkan:
- Username
- Email
- Password

Data akun akan disimpan ke database dan digunakan untuk proses login.

---

## 2. Login Username / Email

Pengguna dapat masuk menggunakan:

- Username
- Email
- Password

Sistem akan melakukan validasi akun sebelum pengguna masuk ke halaman utama.

---

## 3. Tambah Aktivitas

Pengguna dapat menambahkan aktivitas baru.

Data aktivitas:

- Judul aktivitas
- Deskripsi aktivitas
- Kategori aktivitas

Contoh:
Judul:
Jogging Pagi

Kategori:
Olahraga

Deskripsi:
Melakukan jogging selama 30 menit untuk menjaga kesehatan.


---

## 4. Melihat Daftar Aktivitas

Menampilkan seluruh aktivitas pengguna dalam bentuk daftar.

Informasi yang ditampilkan:

- Judul aktivitas
- Deskripsi singkat
- Kategori aktivitas

---

## 5. Detail Aktivitas

Pengguna dapat melihat informasi lengkap dari aktivitas yang dipilih.

Data yang ditampilkan:

- Judul
- Kategori
- Deskripsi

---

## 6. Update Aktivitas

Pengguna dapat mengubah data aktivitas yang sudah dibuat.

Data yang dapat diperbarui:

- Judul aktivitas
- Kategori
- Deskripsi

---

## 7. Hapus Aktivitas

Pengguna dapat menghapus aktivitas yang sudah selesai atau tidak diperlukan.

---

## 8. Manajemen Data Aktivitas (CRUD)

DailySolve menerapkan konsep CRUD:

| Operasi | Fitur |
|---|---|
| Create | Tambah aktivitas |
| Read | Melihat aktivitas |
| Update | Edit aktivitas |
| Delete | Menghapus aktivitas |

---

# c. Daftar Activity

Berikut daftar Activity yang digunakan pada aplikasi DailySolve.

| Activity | Fungsi |
|---|---|
| LoginActivity | Mengatur proses login pengguna |
| RegisterActivity | Membuat akun baru |
| MainActivity | Menampilkan daftar aktivitas pengguna |
| AddReportActivity | Menambahkan aktivitas baru |
| DetailActivity | Menampilkan detail aktivitas |
| EditReportActivity | Mengubah data aktivitas |

---

## Penjelasan Activity

### 1. LoginActivity

Digunakan untuk:
- Input username/email
- Input password
- Validasi akun
- Mengarahkan pengguna ke MainActivity


---

### 2. RegisterActivity

Digunakan untuk:
- Membuat akun baru
- Menyimpan data pengguna
- Validasi input akun


---

### 3. MainActivity

Digunakan sebagai halaman utama aplikasi.

Fungsi:
- Menampilkan daftar aktivitas
- Mengambil data dari database
- Membuka halaman tambah aktivitas


---

### 4. AddReportActivity

Digunakan untuk membuat aktivitas baru.

Input:

- Judul aktivitas
- Kategori
- Deskripsi


---

### 5. DetailActivity

Digunakan untuk menampilkan detail aktivitas.

Fitur:

- Melihat detail aktivitas
- Edit aktivitas
- Menghapus aktivitas
- Kembali ke halaman utama


---

### 6. EditReportActivity

Digunakan untuk memperbarui data aktivitas yang sudah ada.


---

# d. Daftar Intent

Intent digunakan untuk melakukan perpindahan antar Activity.

| Intent | Tujuan |
|---|---|
| LoginActivity → RegisterActivity | Membuka halaman daftar akun |
| RegisterActivity → LoginActivity | Kembali ke halaman login |
| LoginActivity → MainActivity | Masuk ke halaman utama setelah login |
| MainActivity → AddReportActivity | Membuka halaman tambah aktivitas |
| MainActivity → DetailActivity | Membuka detail aktivitas |
| DetailActivity → EditReportActivity | Membuka halaman edit aktivitas |
| DetailActivity → MainActivity | Kembali ke halaman utama |

---

# e. Daftar Widget Android

Widget yang digunakan dalam aplikasi DailySolve:
| Widget       | Fungsi                                   |
| ------------ | ---------------------------------------- |
| EditText     | Input data pengguna dan aktivitas        |
| Button       | Tombol aksi aplikasi                     |
| TextView     | Menampilkan teks/informasi               |
| RecyclerView | Menampilkan daftar aktivitas             |
| CardView     | Membuat tampilan aktivitas lebih menarik |
| LinearLayout | Mengatur tata letak komponen             |
| ScrollView   | Membuat halaman dapat digulir            |
| Toast        | Memberikan pesan kepada pengguna         |

Penggunaan Widget
EditText

Digunakan untuk:

Username,
Email,
Password,
Judul aktivitas,
Kategori,
Deskripsi,
Button

Digunakan untuk:

Login,
Register,
Simpan aktivitas,
Edit aktivitas,
Hapus aktivitas,
Kembali,

RecyclerView:
Digunakan untuk menampilkan daftar aktivitas secara dinamis.

# f. Library Tambahan

### 1. Retrofit

Dependency:

implementation 'com.squareup.retrofit2:retrofit:2.9.0'

Fungsi:

Retrofit digunakan untuk menghubungkan aplikasi Android dengan backend melalui API.

Penggunaan:

Login,
Register,
Menambah aktivitas,
Mengambil data aktivitas,
Update aktivitas,
Delete aktivitas

2. Gson Converter

Dependency:

implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

Fungsi:

Mengubah data JSON dari server menjadi object Java.

Contoh:

Response API:

{
 "status":"success",
 "message":"Berhasil"
}

akan dikonversi menjadi object:

ResponseModel
3. AndroidX AppCompat

Fungsi:

Digunakan untuk mendukung komponen Android modern seperti:

AppCompatActivity
Lifecycle Activity
4. RecyclerView Library

Fungsi:

Digunakan untuk menampilkan daftar aktivitas dengan performa yang baik.

g. Database
Database Name
dailysolve

Database terdiri dari dua tabel utama:

users
activities
Entity Relationship Diagram (ERD)
+----------------+
|     USERS      |
+----------------+
| PK id_user     |
| username       |
| email          |
| password       |
+----------------+
        |
        |
        | 1
        |
        | memiliki
        |
        | N
+----------------+
|   ACTIVITIES   |
+----------------+
| PK id_activity |
| FK id_user     |
| title          |
| description    |
| category       |
| created_at     |
+----------------+

| Field    | Type         | Keterangan        |
| -------- | ------------ | ----------------- |
| id_user  | INT          | Primary Key       |
| username | VARCHAR(50)  | Username pengguna |
| email    | VARCHAR(100) | Email pengguna    |
| password | VARCHAR(255) | Password pengguna |

| Field       | Type         | Keterangan         |
| ----------- | ------------ | ------------------ |
| id_activity | INT          | Primary Key        |
| id_user     | INT          | Foreign Key        |
| title       | VARCHAR(100) | Nama aktivitas     |
| description | TEXT         | Detail aktivitas   |
| category    | VARCHAR(50)  | Kategori aktivitas |
| created_at  | TIMESTAMP    | Waktu dibuat       |

Relasi Database:
Satu pengguna dapat memiliki banyak aktivitas.

Relasi:

1 User
 |
 |
 N Activities

Contoh:

User:
Farrel

Aktivitas:
- Jogging Pagi
- Belajar Java
- Rapat Organisasi
Kesimpulan

DailySolve merupakan aplikasi Android yang membantu pengguna dalam mengelola aktivitas sehari-hari secara digital. Dengan fitur autentikasi pengguna dan manajemen aktivitas berbasis CRUD, pengguna dapat mencatat berbagai kegiatan seperti olahraga, belajar, pekerjaan, organisasi, dan hobi secara lebih terstruktur.

Aplikasi ini menggunakan Android Studio dengan Java, Retrofit sebagai komunikasi API, serta MySQL sebagai penyimpanan data.
