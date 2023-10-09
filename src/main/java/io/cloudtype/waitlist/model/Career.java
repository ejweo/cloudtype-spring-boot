package io.cloudtype.waitlist.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "career")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int num;

    @Column(name="start_date")
    @Temporal(value = TemporalType.DATE)
    private java.util.Date startDate;

    @Column(name="end_date")
    @Temporal(value = TemporalType.DATE)
    private java.util.Date endDate;

    @Column(name="company")
    private String company;

    @Column(name="department")
    private String department;

    @Column(name="rank")
    private String rank;

    @Column(name="position")
    private String position;

    @Column(name = "work")
    private String work;
    
    @Column(name = "technical_book")
    @Lob
    private String technicalBook;
}