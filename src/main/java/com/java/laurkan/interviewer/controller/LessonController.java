package com.java.laurkan.interviewer.controller;

import com.java.laurkan.interviewer.dto.lesson.CreateLessonRequestDTO;
import com.java.laurkan.interviewer.dto.lesson.UpdateLessonRequestDTO;
import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import com.java.laurkan.interviewer.service.LessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) throws ResourceNotFoundException {
        model.addAttribute("lesson", lessonService.findById(id));
        return "lesson";
    }

    @GetMapping("/create/{topicId}")
    public String createLessonPage(@PathVariable("topicId") Long topicId, Model model) {
        model.addAttribute("topicId", topicId);
        return "create-lesson";
    }

    @GetMapping("/{id}/questions")
    public String getQuestionsOfLesson(@PathVariable("id") Long id, Model model) throws ResourceNotFoundException {
        model.addAttribute("lessonId", id);
        model.addAttribute("questions", lessonService.findLessonsOfQuestion(id));
        return "questions";
    }

    @GetMapping("/edit/{lessonId}")
    public String editLessonPage(@PathVariable("lessonId") Long lessonId, Model model) throws ResourceNotFoundException {
        model.addAttribute("lesson", lessonService.findById(lessonId));
        return "edit-lesson";
    }

    @PostMapping("/save")
    public String saveLesson(@ModelAttribute @Valid CreateLessonRequestDTO createLessonRequestDTO, Model model) {
        var lesson = lessonService.save(createLessonRequestDTO);
        return "redirect:/lessons/" + lesson.getId();
    }

    @PostMapping("/update")
    public String updateLesson(@ModelAttribute @Valid UpdateLessonRequestDTO updateLessonRequestDTO, Model model) throws ResourceNotFoundException {
        var lesson = lessonService.update(updateLessonRequestDTO);
        return "redirect:/lessons/" + lesson.getId();
    }
}
