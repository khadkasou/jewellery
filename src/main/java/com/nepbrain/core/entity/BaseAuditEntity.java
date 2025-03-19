package com.nepbrain.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseAuditEntity extends BaseEntity {

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @CreatedBy
    @Column(name = "created_by_id", updatable = false)
    private UUID createdBy;

    @Column(name = "modified_by_id")
    private UUID modifiedBy;


    @Override
    public int hashCode() {
        return Objects.hash(createdAt, lastModifiedAt, createdBy, modifiedBy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseAuditEntity that = (BaseAuditEntity) o;
        return Objects.equals(createdAt, that.createdAt) && Objects.equals(lastModifiedAt, that.lastModifiedAt)
                && Objects.equals(createdBy, that.createdBy) && Objects.equals(modifiedBy, that.modifiedBy);
    }
}
