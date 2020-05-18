package com.bsep.recipes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class RegisteredUser extends User {
	
	@Column
	@Enumerated(EnumType.STRING)
	private UserKnowledgeType knowledge;
	
	@ElementCollection
	@CollectionTable(name = "likes")
	private List<String> likes = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "hates")
	private List<String> hates = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "grade")
	@JsonBackReference(value="registeredUser-grade")
	private List<Grade> grades = new ArrayList<>();

	public RegisteredUser() {
		super();
	}

	public RegisteredUser(String username, String password, String firstName, String lastName,
			List<Authority> authorities) {
		super(username, password, firstName, lastName, authorities);
	}

	public UserKnowledgeType getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(UserKnowledgeType knowledge) {
		this.knowledge = knowledge;
	}

	public List<String> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}

	public List<String> getHates() {
		return hates;
	}

	public void setHates(ArrayList<String> hates) {
		this.hates = hates;
	}
	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
}
