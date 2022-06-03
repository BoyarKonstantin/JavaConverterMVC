package Converter.MVC.Konstantin.controllers;

import Converter.MVC.Konstantin.ConverterDAO.ConverterDAO;
import Converter.MVC.Konstantin.models.ValuteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/converter")
public class ValuteController {
    private static int ID;
    private final ConverterDAO converterDAO;

    @Autowired
    public ValuteController(ConverterDAO converterDAO) {
        this.converterDAO = converterDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("converter", ConverterDAO.index());
        return "main";
    }

    @GetMapping("/addcourse")
    public String addCourseToSite(Model model) {
        model.addAttribute("converter", new ValuteModel());
        return "getCourse";
    }

    @PostMapping()
    public String addActualCourse(@ModelAttribute("converter") ValuteModel valuteModel,
                                  @ModelAttribute("valuteName") String valuteName) {

        converterDAO.addCourse(++ID, valuteModel, valuteName);
        return "redirect:/converter";

    }
}
