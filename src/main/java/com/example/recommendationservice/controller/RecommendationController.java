package com.example.recommendationservice.controller;

import com.example.recommendationservice.model.Recommendation;
import com.example.recommendationservice.repository.RecommendationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
    public class RecommendationController {
    private static Logger logger = LoggerFactory.getLogger(RecommendationController.class);

        @Autowired
        private RecommendationRepository recommendationRepository;

        @GetMapping("/recommendations")
        public List<Recommendation> getRecommendations() {
            return recommendationRepository.findAll();
        }

        @PostMapping("/recommendation")
        public void addRecommendation(@RequestBody Recommendation recommendation) {
            recommendationRepository.save(recommendation);
        }

        @GetMapping("/recommendation/{productId}")
        public  List<Recommendation> getRecommendationprodid(@PathVariable long productId) {
            var recommendations = recommendationRepository.findByProductId(productId);

            logger.info("recommendations by product"+productId);
            return recommendations;
        }

         @DeleteMapping("/delrecommendation/{id}")
         public String deleteRecommendation(@PathVariable long id) {
             var recommendations = recommendationRepository.findByProductId(id);
          if(!recommendations.isEmpty()){
              for(Recommendation rec :  recommendations){
                  recommendationRepository.delete(rec);
                  logger.info("deleted "+rec.getId());
              }

          }

            return "OK";
         }
    }
