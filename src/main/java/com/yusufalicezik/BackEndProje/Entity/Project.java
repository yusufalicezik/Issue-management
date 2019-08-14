package com.yusufalicezik.BackEndProje.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data //getter setter
@NoArgsConstructor // boş constructor yaratır.
@AllArgsConstructor //dolu olanı
@ToString //nesnenin toStringi oluşur
@EqualsAndHashCode(callSuper = false) //equals methodu
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_code")
    private String projectCode;

    @Column(name = "project_name")
    private String projectName;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;
}
