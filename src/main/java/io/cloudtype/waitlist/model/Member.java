package io.cloudtype.waitlist.model;

import lombok.*;

import java.util.UUID;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "number")
    private int num;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "phone_num", nullable = false)
    private String phoneNum;

    @Column(name = "member_level", nullable = false)
    private String memberLevel;

    @Column(name = "join_kfa")
    private boolean joinKfa = false;

    @Column(name = "cost")
    private int cost;

    @Column(name = "desc")
    private String desc;
}
