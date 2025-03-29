package com.java.laurkan.interviewer.controller;

import com.java.laurkan.interviewer.dto.question.CreateQuestionRequestDTO;
import com.java.laurkan.interviewer.dto.question.UpdateQuestionRequestDTO;
import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import com.java.laurkan.interviewer.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/create/{lessonId}")
    public String createLessonPage(@PathVariable("lessonId") Long lessonId, Model model) {
        model.addAttribute("lessonId", lessonId);
        return "create-question";
    }

    @PostMapping("/save")
    public String saveLesson(@ModelAttribute @Valid CreateQuestionRequestDTO createQuestionRequestDTO, Model model) {
        questionService.save(createQuestionRequestDTO);
        return "redirect:/lessons/" + createQuestionRequestDTO.getLessonId() + "/questions";
    }

    @GetMapping("/edit/{questionId}")
    public String editLessonPage(@PathVariable("questionId") Long questionId, Model model) throws ResourceNotFoundException {
        model.addAttribute("question", questionService.findById(questionId));
        return "edit-question";
    }

    @PostMapping("/update")
    public String updateLesson(@ModelAttribute @Valid UpdateQuestionRequestDTO updateQuestionRequestDTO, Model model) throws ResourceNotFoundException {
        var question = questionService.update(updateQuestionRequestDTO);
        return "redirect:/lessons/" + question.getLesson().getId() + "/questions";
    }
}
