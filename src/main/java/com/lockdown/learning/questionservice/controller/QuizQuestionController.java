package com.lockdown.learning.questionservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lockdown.learning.questionservice.model.QuizQuestion;
import com.lockdown.learning.questionservice.model.Tag;
import com.lockdown.learning.questionservice.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuizQuestionController {

	QuestionService service;

	public QuizQuestionController(QuestionService service) {
		this.service = service;
	}

	@PostMapping("/new")
	@ResponseBody
	public QuizQuestion createQuestion(@RequestBody QuizQuestion rawData) {
		QuizQuestion saved = service.save(rawData);
		return saved;
	}

	@PostMapping("/createMultiple")
	@ResponseBody
	public List<QuizQuestion> createMultipleQuestion(@RequestBody List<QuizQuestion> rawData) {
		List<QuizQuestion> saved = service.saveAll(rawData);
		return saved;
	}

	@GetMapping
	@ResponseBody
	public List<QuizQuestion> listAllQuestions() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public QuizQuestion getQuestion(@PathVariable Long id) {
		return service.getById(id);
	}

	@PutMapping("/{id}")
	public QuizQuestion updateQuestion(@PathVariable Long id, @RequestBody QuizQuestion questionToUpdate) {
		QuizQuestion updated = service.update(id, questionToUpdate);
		return updated;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public QuizQuestion deleteQuestion(@PathVariable Long id) {
		return service.delete(id);
	}

	@PostMapping("deleteMultiple")
	@ResponseBody
	public List<QuizQuestion> deleteMultipleQuestions(@RequestBody ArrayList<Long> qIDs) {
		final List<QuizQuestion> deletedQuestions = service.deleteMultiple(qIDs);
		return deletedQuestions;
	}

	@DeleteMapping("/deleteAll")
	@ResponseBody
	public String deleteAllQuestions() {
		return service.deleteAll();
	}
}
