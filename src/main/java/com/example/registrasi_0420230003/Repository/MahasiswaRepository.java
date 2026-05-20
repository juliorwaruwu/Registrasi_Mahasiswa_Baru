package com.example.registrasi_0420230003.Repository;

import com.example.registrasi_0420230003.Model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MahasiswaRepository
        extends JpaRepository<Mahasiswa, Long> {

    Optional<Mahasiswa> findByEmail(String email);

    List<Mahasiswa>
    findByNamaContainingIgnoreCaseOrNimContaining(
            String nama,
            String nim
    );

    long countByStatus(String status);

    long countByProdi(String prodi);
}