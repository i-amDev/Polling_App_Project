package com.project.voting_app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @ElementCollection // this annotation will create an entity/table by name "poll_options" with "poll_id" and "options" columns.
    private List<OptionVote> options = new ArrayList<>();

//    private List<Long> votes = new ArrayList<>();
}
