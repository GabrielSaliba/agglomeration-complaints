package com.example.agglomerationcomplaints.domain;

import com.example.agglomerationcomplaints.domain.enums.AgglomerationType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Table
@Entity
@Getter
@Setter
public class Agglomeration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "creation_date")
    @CreationTimestamp
    LocalDateTime creationDate;

    @Column(name = "modification_date")
    @UpdateTimestamp
    LocalDateTime modificationDate;

    @NotBlank
    @NotNull
    @Column
    String name;

    @Size(max = 550)
    @Column
    String observation;

//    @NotNull
    @Column(name = "agglomeration_type")
    String agglomerationType;

//    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    Location location;

//    @NotNull
    @OneToOne
    Image image;
}
