package com.github.pkg.countryapi.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Comparable<Country> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Length(max = 255)
    private String name;

    @NotNull
    @Length(max = 255)
    private String capital;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private long population;

    @NotNull
    @Length(max = 255)
    private String subregion;

    @Length(max = 255)
    private String flagSrc;

    @Length(max = 255)
    private String language;

    @Length(max = 255)
    private String domainExtension;

    @Override
    public int compareTo(Country other) {
        return this.getName().compareTo(other.getName());
    }
}
