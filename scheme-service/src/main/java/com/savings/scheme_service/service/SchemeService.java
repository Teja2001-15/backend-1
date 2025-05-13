package com.savings.scheme_service.service;

import com.savings.scheme_service.model.Scheme;
import com.savings.scheme_service.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchemeService {

    @Autowired
    private SchemeRepository schemeRepository;

    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }

    public Optional<Scheme> getSchemeById(String id) {
        return schemeRepository.findById(id);
    }

    public Scheme addScheme(Scheme scheme) {
        return schemeRepository.save(scheme);
    }

    public Scheme updateScheme(String id, Scheme updatedScheme) {
        Scheme existing = schemeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scheme not found"));
        existing.setName(updatedScheme.getName());
        existing.setDescription(updatedScheme.getDescription());
        existing.setInterestRate(updatedScheme.getInterestRate());
        existing.setEligibility(updatedScheme.getEligibility());
        existing.setType(updatedScheme.getType());
        return schemeRepository.save(existing);
    }

    public void deleteScheme(String id) {
        schemeRepository.deleteById(id);
    }
}
