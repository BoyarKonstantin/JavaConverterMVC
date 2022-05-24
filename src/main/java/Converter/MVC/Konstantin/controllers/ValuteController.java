package Converter.MVC.Konstantin.controllers;

import Converter.MVC.Konstantin.ConverterDAO.ConverterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/converter")
public class ValuteController {
    private final ConverterDAO converterDAO;
    @Autowired
    public ValuteController(ConverterDAO converterDAO) {
        this.converterDAO = converterDAO;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("converter", ConverterDAO.index());
        return "converter";
    }
}
