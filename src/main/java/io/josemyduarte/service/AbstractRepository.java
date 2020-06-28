package io.josemyduarte.service;

import java.util.HashMap;
import java.util.Map;

import io.josemyduarte.view.DynamoGameScore;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

public abstract class AbstractRepository {

    public final static String USER_ID_COL = "userId";
    public final static String GAME_TITLE_COL = "gameTitle";
    public final static String TOP_SCORE_COL = "topScore";

    public String getTableName() {
        return "GameScores";
    }

    protected ScanRequest scanRequest() {
        return ScanRequest.builder().tableName(getTableName())
                .attributesToGet(USER_ID_COL, GAME_TITLE_COL).build();
    }

    protected PutItemRequest putRequest(DynamoGameScore gameScore) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put(USER_ID_COL, AttributeValue.builder().s(gameScore.getUserId()).build());
        item.put(GAME_TITLE_COL, AttributeValue.builder().s(gameScore.getGameTitle()).build());
        item.put(TOP_SCORE_COL, AttributeValue.builder().n(String.valueOf(gameScore.getTopScore())).build());

        return PutItemRequest.builder()
                .tableName(getTableName())
                .item(item)
                .build();
    }

    protected GetItemRequest getRequest(String userId) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put(USER_ID_COL, AttributeValue.builder().s(userId).build());

        return GetItemRequest.builder()
                .tableName(getTableName())
                .key(key)
                .attributesToGet(USER_ID_COL, GAME_TITLE_COL, TOP_SCORE_COL)
                .build();
    }
}
