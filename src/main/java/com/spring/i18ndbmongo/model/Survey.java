package com.spring.i18ndbmongo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "survey")
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString

@JsonIgnoreProperties
@Data
public class Survey {

    @Id
    private String id;

    private String title;

    private String email;

    private EN en;

    private SH sh;


}
