package at.rt.sample.springboot.service.impl;

import at.rt.sample.springboot.dto.mapper.IngredientMapper;
import at.rt.sample.springboot.dto.model.IngredientModel;
import at.rt.sample.springboot.models.Ingredient;
import at.rt.sample.springboot.repo.IngredientsRepository;
import at.rt.sample.springboot.service.api.IIngredientsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 01.06.2021
 */
@Service
public class IngredientsServiceImpl implements IIngredientsService {

    private final IngredientsRepository ingredientsRepository;
    private final IngredientMapper ingredientMapper = IngredientMapper.INSTANCE;

    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public IngredientModel findById(Long id) {
        return ingredientsRepository.findById(id)
                .map(ingredientMapper::entityToModel)
                .orElseThrow(() -> new NullPointerException("cannot find recipe with given id"));
    }

    @Override
    public Page<IngredientModel> findAll(Pageable pageable, Optional<String> filter) {
        return filter
                .map(f -> ingredientsRepository.findAllByFilter(f, pageable))
                .orElse(ingredientsRepository.findAll(pageable))
                .map(ingredientMapper::entityToModel);
    }

    @Override
    @Transactional
    public IngredientModel createIngredient(IngredientModel ingredientModel) {
        return ingredientMapper.entityToModel(ingredientsRepository
                .save(ingredientMapper.modelToEntity(ingredientModel)));
    }

    @Override
    @Transactional
    public void deleteIngredient(IngredientModel ingredientModel) {
        ingredientsRepository.delete(ingredientMapper.modelToEntity(ingredientModel));
    }
}
