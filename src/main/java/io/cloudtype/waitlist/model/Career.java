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
    private Date startDate;

    @Column(name="end_date")
    @Temporal(value = TemporalType.DATE)
    private Date endDate;

    private String company;

    private String department;

    private String rank;

    private String position;

    @Column(name = "work")
    private String work;

    @Column(name = "technical_book")
    @Lob
    private String technicalBook;
}