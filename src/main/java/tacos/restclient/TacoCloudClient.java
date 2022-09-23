package tacos.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tacos.Ingredient;

@Service
@Slf4j
public class TacoCloudClient {

    private RestTemplate restTemplate;

    public TacoCloudClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Ingredient getIngredientById(String ingredientId){
        return restTemplate.getForObject("http://localhost:8080/data-api/ingredients/{id}",
                Ingredient.class, ingredientId);
    }

    public void updateIngredient(Ingredient ingredient){
        restTemplate.put("http://localhost:8080/data-api/ingredients/{id}",
                ingredient, ingredient.getId());
    }
}
