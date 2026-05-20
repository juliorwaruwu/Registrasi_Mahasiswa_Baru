package com.example.registrasi_0420230003.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "mahasiswa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nama wajib diisi")
    @Size(min = 4, message = "inputan nama tidak valid, kurang dari empat karakter")
    private String nama;

    @NotBlank(message = "NIM wajib diisi")
    @Pattern(regexp = "^[0-9]{10}$", message = "Panjang NIM tidak valid")
    @Column(unique = true)
    private String nim;

    @Email(message = "Format email tidak valid")
    @NotBlank(message = "Email wajib diisi")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^(08|62)[0-9]{8,11}$", message = "Nomor HP tidak valid")
    private String nomorHp;

    private LocalDate tanggalLahir;

    @Size(min = 15, message = "Alamat minimal 15 karakter")
    private String alamat;

    private String prodi;

    private String asalSekolah;

    private LocalDate tanggalDaftar;

    private String nomorRegistrasi;

    private String status = "PENDING";
}