package com.example.AnimeListDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AnimeList")

public class AnimeEntity
{
    @Id

    private Long id;

    @Column(name = "Anime_Name")
    private String animeName;

    @Column(name = "Main_lead_Name")
    private String mainLeadName;
}
