package com.java.laurkan.interviewer.controller;

import com.java.laurkan.interviewer.dto.topic.CreateTopicRequestDTO;
import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import com.java.laurkan.interviewer.service.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping
    public String all(@RequestParam(required = false) String title, Pageable pageable, Model model) {
        model.addAttribute("root", true);
        model.addAttribute("topics", topicService.findAll(title, pageable));
        return "topics";
    }

    @GetMapping("/{id}/child")
    public String findChild(@PathVariable Long id, Model model) throws ResourceNotFoundException {
        model.addAttribute("back_id", topicService.findParentOfTopic(id));
        model.addAttribute("topics", topicService.findAllByParentId(id));
        model.addAttribute("parent_id", id);
        return "topics";
    }

    @GetMapping("/{id}/lessons")
    public String findLessonsOfTopic(@PathVariable Long id, Model model) throws ResourceNotFoundException {
        model.addAttribute("back_id", topicService.findParentOfTopic(id));
        model.addAttribute("lessons", topicService.findLessonsOfTopic(id));
        model.addAttribute("parent_id", id);
        return "lessons";
    }

    @GetMapping({"/create/{parentId}", "/create"})
    public String createTopicTemplate(@PathVariable(required = false) Long parentId, Model model) {
        model.addAttribute("parents", topicService.findAll());
        model.addAttribute("parent_id", parentId);
        return "create-update-topic";
    }

    @PostMapping
    public String createTopic(@ModelAttribute @Valid CreateTopicRequestDTO data) {
        topicService.save(data);
        return "redirect:/topics";
    }

    @GetMapping("/update/{id}")
    public String updateTopic(@PathVariable Long id, Model model) {
        return "create-update-topic";
    }

    /*@GetMapping
    public String findAllDirections(@RequestParam(name = "title", required = false) String search, Pageable pageable, Model model) {
        model.addAttribute("page", directionService.findAll(search, pageable));
        return "knowledge_base";
    }*/
}
