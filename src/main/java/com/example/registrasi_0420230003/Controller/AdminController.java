package com.example.registrasi_0420230003.Controller;

import com.example.registrasi_0420230003.Service.MahasiswaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MahasiswaService service;

    public AdminController(MahasiswaService service) {
        this.service = service;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute(
                "total",
                service.totalPendaftar()
        );

        model.addAttribute(
                "pending",
                service.totalPending()
        );

        model.addAttribute(
                "verified",
                service.totalVerified()
        );

        model.addAttribute(
                "list",
                service.getAll()
        );

        model.addAttribute(
                "tiCount",
                service.countByProdi(
                        "Teknik Informatika"
                )
        );

        model.addAttribute(
                "siCount",
                service.countByProdi(
                        "Sistem Informasi"
                )
        );

        model.addAttribute(
                "akuntansiCount",
                service.countByProdi(
                        "Akutansi"
                )
        );
       
        model.addAttribute(
                "sastraJepangCount",
                service.countByProdi(
                        "Sastra Jepang"
                )
        );

     
          model.addAttribute(
                "inggrisCount",
                service.countByProdi(
                        "Sastra Inggris"
                )
        );
          model.addAttribute(
                "desainCount",
                service.countByProdi(
                        "Visualisasi dan Komunikasi Visual"
                )
        );

        return "dashboard";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam String keyword,
            Model model
    ) {

        model.addAttribute(
                "list",
                service.search(keyword)
        );

        return "search";
    }

    @GetMapping("/verify/{id}")
    public String verifyPage(
            @PathVariable Long id,
            Model model
    ) {

        model.addAttribute(
                "mahasiswa",
                service.getById(id)
        );

        return "verify";
    }

    @PostMapping("/verify/{id}")
    public String verify(
            @PathVariable Long id,
            @RequestParam String status
    ) {

        service.updateStatus(id, status);

        return "redirect:/admin/dashboard";
    }
}