package com.example.jumpstart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "customers")
//Entity + Table turn class into
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "firstName")
    String firstName;

    @Column
    String gender;

    @Column
    String address;

    @Column
    String city;

    @Column
    String state;

//   @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
//    //To make this association bidirectional use mappedBy
//    // Cascade: When we perform some action on the target entity, the same action will be applied to the associated entity.
//    private List<Order> order;

    @Column
    double longitude;

    @Column
    double latitude;

}
