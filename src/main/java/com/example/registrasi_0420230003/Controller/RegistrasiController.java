package com.example.registrasi_0420230003.Controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.registrasi_0420230003.Model.Mahasiswa;
import com.example.registrasi_0420230003.Service.MahasiswaService;

@Controller
public class RegistrasiController {

    private final MahasiswaService service;

    public RegistrasiController(MahasiswaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute Mahasiswa mahasiswa,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {
            return "register";
        }

        try {
            service.save(mahasiswa);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }

        return "success";
    }
}