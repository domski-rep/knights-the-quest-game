package kngihts.thequestgame.knightsgame.controllers;

import kngihts.thequestgame.knightsgame.components.TimeComponent;
import kngihts.thequestgame.knightsgame.domain.models.Knight;
import kngihts.thequestgame.knightsgame.domain.models.PlayerInformation;
import kngihts.thequestgame.knightsgame.domain.models.Quest;
import kngihts.thequestgame.knightsgame.services.KnightService;
import kngihts.thequestgame.knightsgame.services.QuestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;
    @Autowired
    QuestService questService;
    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/assignQuest")
    public String assingQuest(@RequestParam("knightId") Integer id, Model model) {

        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuests", notStartedQuests);

        return "assignQuest";
    }

    @RequestMapping(value = "/assignQuest", method = RequestMethod.POST)
    public String assingQuest(Knight knight) {

        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.update(quest);

        return "redirect:/knights";
    }

    @RequestMapping(value = "/checkQuests", method = RequestMethod.GET)
    public String checkQuest() {

        knightService.getMyGold();
        return "redirect:/knights";
    }

}
