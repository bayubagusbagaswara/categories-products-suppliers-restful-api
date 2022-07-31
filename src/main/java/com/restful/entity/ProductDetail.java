package com.restful.entity;

import com.restful.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.Instant;

@Entity
@Table(name = "product_detail", uniqueConstraints = {
        @UniqueConstraint(name = "product_detail_unique_sku", columnNames = "sku")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE product_detail SET status_record = 'INACTIVE' WHERE id = ?")
@Where(clause = "status_record = 'ACTIVE'")
public class ProductDetail extends BaseEntity {

    @Column(name = "sku", nullable = false, length = 50)
    private String sku;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Override
    public void setUpdatedAt(Instant updatedAt) {
        super.setUpdatedAt(updatedAt);
    }

    @Override
    public void setCreatedAt(Instant createdAt) {
        super.setCreatedAt(createdAt);
    }
}
