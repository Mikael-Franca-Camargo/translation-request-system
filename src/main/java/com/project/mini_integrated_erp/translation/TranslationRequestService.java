package com.project.mini_integrated_erp.translation;

import com.project.mini_integrated_erp.shared.InvalidRequestException;
import com.project.mini_integrated_erp.shared.NotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TranslationRequestService {

    private final TranslationRequestRepository repository;
    private final MessageSource messageSource;

    public TranslationRequestService(TranslationRequestRepository repository, MessageSource messageSource) {
        this.repository = repository;
        this.messageSource = messageSource;
    }

    public TranslationRequest createTranslationRequest(String requesterName, Integer wordCount) {
        TranslationRequest tr = new TranslationRequest(requesterName, wordCount);
        return repository.save(tr);
    }

    public TranslationRequest approveTranslationRequest(Long id, Locale locale) {
        TranslationRequest tr = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        messageSource.getMessage("translationRequest.notFound", null, locale)
                ));

        if (tr.getStatus() == RequestStatus.APPROVED) {
            throw new InvalidRequestException(
                    messageSource.getMessage("translationRequest.alreadyApproved", null, locale)
            );
        }

        tr.setStatus(RequestStatus.APPROVED);
        return repository.save(tr);
    }

    public Iterable<TranslationRequest> getAllTranslationRequests() {
        return repository.findAll();
    }

    public TranslationRequest getTranslationRequestById(Long id, Locale locale) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        messageSource.getMessage("translationRequest.notFound", null, locale)
                ));
    }
}

