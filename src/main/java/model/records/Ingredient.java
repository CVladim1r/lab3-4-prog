package model.records;

import model.enums.IngredientType;

public record Ingredient(IngredientType type, int amount) {
}

