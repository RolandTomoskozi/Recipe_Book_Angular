INSERT INTO INGREDIENT (ID, NAME, AMOUNT)
VALUES (SQX_INGREDIENT.nextval, 'ABC', 1);

INSERT INTO ingredient_recipe(recipe_id, ingredient_id)
values (1, SQX_INGREDIENT.currval);

