package com.hiresmart.server.controller;

import com.hiresmart.server.dto.request.CompanyRequest;
import com.hiresmart.server.dto.response.CompanyResponse;
import com.hiresmart.server.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<String> createCompany(
            @RequestBody CompanyRequest request) {

        return ResponseEntity.ok(
                companyService.createCompany(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {

        return ResponseEntity.ok(
                companyService.getAllCompanies()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompanyById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                companyService.getCompanyById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(
            @PathVariable Integer id,
            @RequestBody CompanyRequest request) {

        return ResponseEntity.ok(
                companyService.updateCompany(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                companyService.deleteCompany(id)
        );
    }

}