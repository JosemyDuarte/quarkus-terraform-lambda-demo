package io.josemyduarte.service;

import io.josemyduarte.view.DynamoGameScore;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GameScoreRepository extends AbstractRepository {

    @Inject
    DynamoDbClient dynamoDB;


    public List<DynamoGameScore> findAll() {
        return dynamoDB.scanPaginator(scanRequest()).items().stream()
                .map(DynamoGameScore::from)
                .collect(Collectors.toList());
    }

    public List<DynamoGameScore> add(DynamoGameScore fruit) {
        dynamoDB.putItem(putRequest(fruit));
        return findAll();
    }

    public DynamoGameScore get(String userId) {
        return DynamoGameScore.from(dynamoDB.getItem(getRequest(userId)).item());
    }
}
