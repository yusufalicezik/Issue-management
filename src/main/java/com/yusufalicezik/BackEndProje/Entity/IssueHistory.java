package com.yusufalicezik.BackEndProje.Entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "issue_history")
@Data //getter setter
@NoArgsConstructor // boş constructor yaratır.
@AllArgsConstructor //dolu olanı
@ToString //nesnenin toStringi oluşur
@EqualsAndHashCode(callSuper = false) //equals methodu
public class IssueHistory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "issue_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Issue issue;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee; //issue geçmişi

}
