package com.yusufalicezik.BackEndProje.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
@Data //getter setter
@NoArgsConstructor // boş constructor yaratır.
@AllArgsConstructor //dolu olanı
@ToString //nesnenin toStringi oluşur
@EqualsAndHashCode //equals methodu
public class Issue extends BaseEntity { //entity ve id anosu olmak zorunda.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //oto id //auto değil de squence yaparsak auto increate olur.
    private Long id;

    @Column(name = "description", length = 400)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    private Date date;

    @Column(name = "issueStatus")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id") //join işlemleri bir çok issue bir usera
    @ManyToOne(optional = true,fetch = FetchType.LAZY) //join işlemi, optional bu issue null kalsa da olur bi kullanıcıya atamaya gerek yok.Selectte gelmesi fetch type.
    private User user;


}
