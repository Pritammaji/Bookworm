package com.vita.bookworm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.bookworm.Models.LanguageMaster;
import com.vita.bookworm.Repository.LanguageMasterRepository;

@Service
public class LanguageMasterService {
    LanguageMasterRepository languageMasterRepository;

    @Autowired
    public LanguageMasterService(LanguageMasterRepository languageMasterRepository) {
        this.languageMasterRepository = languageMasterRepository;
    }

    public LanguageMaster getLanguageById(int id) {
        return languageMasterRepository.findById(id).orElse(null);
    }
}
