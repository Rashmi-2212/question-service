package com.lockdown.learning.questionservice.model;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestion {
	private Long id;
	private String questions;
	private List<String> answers = new ArrayList<>(5); 
	private List<Tag> tags;
	private String correctAnswer;
	private int totalAnswers;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getTotalAnswers() {
		return totalAnswers;
	}
	public void setTotalAnswers(int totalAnswers) {
		this.totalAnswers = totalAnswers;
	}
	@Override
	public String toString() {
		return "QuizQuestion [id=" + id + ", questions=" + questions + ", answers=" + answers + ", tags=" + tags
				+ ", correctAnswer=" + correctAnswer + ", totalAnswers=" + totalAnswers + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuizQuestion other = (QuizQuestion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
