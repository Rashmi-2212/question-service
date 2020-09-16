package com.lockdown.learning.questionservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lockdown.learning.questionservice.model.QuizQuestion;

@Service
public class QuestionService {
	
	public static long count = 0;
	private Map<Long, QuizQuestion> data = new HashMap<>();
	
	public QuizQuestion save(QuizQuestion rawData) {
		rawData.setId(count++);
		// adding info to map
		data.put(rawData.getId(), rawData);
		
		// returing on the basis of id
		return data.get(rawData.getId());
	}

	public QuizQuestion getById(Long id) {
		if(data.containsKey(id)) {
			return data.get(id);
		}else {
			return null;
		}
	}
	
	public List<QuizQuestion> findAll() {
		List<QuizQuestion> list = new ArrayList<QuizQuestion>();
		for (Map.Entry<Long, QuizQuestion> entry: data.entrySet() ) {
			list.add(data.get(entry.getValue()));
		}
		return list;
	}

	public QuizQuestion update(Long id, QuizQuestion toUpdate) {
		QuizQuestion existing = getById(id);
		if(toUpdate.getAnswers() != null)
			existing.setAnswers(toUpdate.getAnswers());
		if(toUpdate.getCorrectAnswer() != null)
			existing.setCorrectAnswer(toUpdate.getCorrectAnswer());
		
		if(toUpdate.getQuestions() != null)
		existing.setQuestions(toUpdate.getQuestions());
		
		if(toUpdate.getTags() != null)
		existing.setTags(toUpdate.getTags());
		
		if(toUpdate.getTotalAnswers() != 0)
			existing.setTotalAnswers(toUpdate.getTotalAnswers());
		
		data.put(existing.getId(), existing);
		
		// returing on the basis of id
		return data.get(existing.getId());

	}

	public void delete(Long id) {
		if(data.containsKey(id)) {
			QuizQuestion value = data.get(id);
			data.remove(id, value);
		}		
	}

}
