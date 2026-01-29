package com.project.mini_integrated_erp.translation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/translation-requests")
public class TranslationRequestController {

    private final TranslationRequestService service;

    public TranslationRequestController(TranslationRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TranslationRequest> create(@RequestBody TranslationRequestDTO dto) {
        TranslationRequest tr = service.createTranslationRequest(dto.requesterName(), dto.wordCount());
        return ResponseEntity.ok(tr);
    }

    @GetMapping
    public ResponseEntity<Iterable<TranslationRequest>> getAll() {
        return ResponseEntity.ok(service.getAllTranslationRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TranslationRequest> getById(@PathVariable Long id,
                                                      @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(service.getTranslationRequestById(id, locale));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<TranslationRequest> approve(@PathVariable Long id,
                                                      @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(service.approveTranslationRequest(id, locale));
    }
}
