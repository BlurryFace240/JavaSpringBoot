package com.endava.demo.controller;

import com.endava.demo.entity.Intern;
import com.endava.demo.internRepo.internRepo;
import com.endava.demo.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.endava.demo.entity.InternStreams.NET;

@Controller
public class InternController {

    @Autowired
   private InternService internService;
    private internRepo internRepo;

    @GetMapping("/newForm")
    public String secondView(Model model) {
        model.addAttribute("intern", new Intern(1,"Serghei", 27, NET));
        return "newForm";
    }

    @PostMapping(value = "/newForm")
    public String fillForm(@ModelAttribute Intern intern){
        internService.add(intern);
        return "redirect:/";
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteIntern(@PathVariable int id)
    {
        internService.remove(id);
        return  "redirect:/";
    }

    static int id=0;
    @GetMapping(value = "/update/{id}")
    public String displayIntern(@ModelAttribute Intern intern,Model model)
    {
        id=intern.getId();
        System.err.println(id);
        model.addAttribute("intern",internService.getByID(id));
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String updateIntern(@ModelAttribute Intern intern)
    {
        internService.update(id,intern);
        return "redirect:/";
    }
}
