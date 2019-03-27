package com.endava.demo.controller;

import com.endava.demo.dao.impl.InternDAOImpl;
import com.endava.demo.entity.Intern;
import com.endava.demo.entity.InternStreams;
import com.endava.demo.internRepo.internRepo;
import com.endava.demo.internRepo.internRepoImpl;
import com.endava.demo.service.InternService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.endava.demo.entity.InternStreams.NET;

@Controller
public class InternController {

    @Autowired
   private InternService internService;
    private internRepo internRepo;

    @GetMapping("/newForm")
    public String secondView(Model model) {
        model.addAttribute("intern", new Intern("Serghei", 27, NET));
        return "newForm";
    }

    @PostMapping(value = "/newForm")
    public String fillForm(@ModelAttribute Intern intern){
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Intern.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

//       session.save();
//       session.saveOrUpdate();
//       session.persist();
//       session.merge();

        internRepo ir = new internRepoImpl(session);
        ir.save(new Intern("Eugen",18, InternStreams.JAVA));
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
        System.err.println(intern);
        id=intern.getId();
        System.err.println(id);
        model.addAttribute("intern",internService.getByID(intern.getId()));
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String updateIntern(@ModelAttribute Intern intern)
    {
        System.err.println(intern);
        System.err.println(id);
        internService.update(id,intern);
        return "redirect:/";
    }
}
