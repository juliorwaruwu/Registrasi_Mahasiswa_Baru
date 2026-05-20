package com.example.registrasi_0420230003.Service;

import com.example.registrasi_0420230003.Model.Mahasiswa;
import com.example.registrasi_0420230003.Repository.MahasiswaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class MahasiswaService {

    private final MahasiswaRepository repository;

    public MahasiswaService(MahasiswaRepository repository) {
        this.repository = repository;
    }

    public void save(Mahasiswa mahasiswa) {

        int umur = Period.between(
                mahasiswa.getTanggalLahir(),
                LocalDate.now()
        ).getYears();

        if (umur < 18) {
            throw new RuntimeException(
                    "Umur minimal 18 tahun"
            );
        }

        repository.findByEmail(mahasiswa.getEmail())
                .ifPresent(m -> {
                    throw new RuntimeException(
                            "Email sudah digunakan"
                    );
                });

        mahasiswa.setTanggalDaftar(LocalDate.now());

        long total = repository.count() + 1;

        String nomorRegistrasi =
                "REG-" +
                LocalDate.now().getYear() +
                "-" +
                String.format("%03d", total);

        mahasiswa.setNomorRegistrasi(
                nomorRegistrasi
        );

        repository.save(mahasiswa);
    }

    public List<Mahasiswa> getAll() {
        return repository.findAll();
    }

    public List<Mahasiswa> search(String keyword) {
        return repository
                .findByNamaContainingIgnoreCaseOrNimContaining(
                        keyword,
                        keyword
                );
    }

    public Mahasiswa getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void updateStatus(Long id, String status) {

        Mahasiswa mahasiswa = getById(id);

        mahasiswa.setStatus(status);

        repository.save(mahasiswa);
    }

    public long totalPendaftar() {
        return repository.count();
    }

    public long totalPending() {
        return repository.countByStatus("PENDING");
    }

    public long totalVerified() {
        return repository.countByStatus("VERIFIED");
    }

    public long countByProdi(String prodi) {
        return repository.countByProdi(prodi);
    }
}