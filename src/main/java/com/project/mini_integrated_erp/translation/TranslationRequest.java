package com.project.mini_integrated_erp.translation;

import jakarta.persistence.*;

@Entity
@Table(name = "translation_requests")
public class TranslationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String requesterName;

    @Column(nullable = false)
    private Integer wordCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status;

    protected TranslationRequest() {
    }

    public TranslationRequest(String requesterName, Integer wordCount) {
        this.requesterName = requesterName;
        this.wordCount = wordCount;
        this.status = RequestStatus.CREATED;
    }

    public Long getId() { return id; }
    public String getRequesterName() { return requesterName; }
    public void setRequesterName(String requesterName) { this.requesterName = requesterName; }
    public Integer getWordCount() { return wordCount; }
    public void setWordCount(Integer wordCount) { this.wordCount = wordCount; }
    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }
}
