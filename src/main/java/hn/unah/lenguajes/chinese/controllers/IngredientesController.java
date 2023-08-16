package hn.unah.lenguajes.chinese.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.services.impl.IngredientesImpl;

@RestController
@RequestMapping("/ingredientes")
public class IngredientesController {
    @Autowired
    IngredientesImpl ingredientesImpl;

}
