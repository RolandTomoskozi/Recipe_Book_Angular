package at.rt.sample.springboot.service.impl;

import at.rt.sample.springboot.dto.mapper.RecipeMapper;
import at.rt.sample.springboot.dto.model.RecipeModel;
import at.rt.sample.springboot.repo.RecipeRepository;
import at.rt.sample.springboot.service.api.IRecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 01.06.2021
 */
@Service
public class RecipeServiceImpl implements IRecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper = RecipeMapper.INSTANCE;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public RecipeModel findById(Long id) {
        return recipeRepository.findById(id)
                .map(recipeMapper::entityToModel)
                .orElseThrow(() -> new NullPointerException("cannot find recipe with given id"));
    }

    @Override
    public Page<RecipeModel> findAll(Pageable pageable, Optional<String> filter) {
        return filter
                .map(f -> recipeRepository.findAllByFilter(f, pageable))
                .orElse(recipeRepository.findAll(pageable))
                .map(recipeMapper::entityToModel);
    }

    @Transactional
    @Override
    public RecipeModel createRecipe(RecipeModel recipe) {
        return recipeMapper.entityToModel(recipeRepository.save(recipeMapper.modelToEntity(recipe)));
    }

    @Transactional
    @Override
    public void deleteRecipe(RecipeModel recipe) {
        recipeRepository.delete(recipeMapper.modelToEntity(recipe));
    }
}
