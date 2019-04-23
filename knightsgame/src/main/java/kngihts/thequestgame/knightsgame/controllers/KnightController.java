package kngihts.thequestgame.knightsgame.controllers;

import kngihts.thequestgame.knightsgame.components.TimeComponent;
import kngihts.thequestgame.knightsgame.domain.models.Knight;
import kngihts.thequestgame.knightsgame.domain.models.PlayerInformation;
import kngihts.thequestgame.knightsgame.services.KnightService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KnightController {

    private static final Logger LOGGER =  Logger.getLogger(QuestController.class);

    @Autowired
    TimeComponent timeComponent;
    @Autowired
    KnightService knightService;
    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = knightService.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knights";

    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
           LOGGER.error("There where errors with saving a Knight");
            bindingResult.getAllErrors().forEach(e -> System.out.println(e.getObjectName() + " " + e.getDefaultMessage()));
            return "knightform";
        }else   {
            knightService.saveKnight(knight);
            return "redirect:/knights";
        }
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight (@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights";
    }
}
