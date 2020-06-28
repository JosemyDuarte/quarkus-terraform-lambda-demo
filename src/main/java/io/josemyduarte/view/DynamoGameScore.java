package io.josemyduarte.view;

import io.josemyduarte.service.AbstractRepository;
import lombok.Builder;
import lombok.Data;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Map;
import java.util.Optional;

@Data
@Builder
public class DynamoGameScore {
    private final String userId;
    private final String gameTitle;
    private final Integer topScore;

    public static DynamoGameScore from(final Map<String, AttributeValue> databaseItem) {
        return Optional.ofNullable(databaseItem)
                .map(item -> DynamoGameScore.builder()
                        .userId(databaseItem.get(AbstractRepository.USER_ID_COL).s())
                        .gameTitle(databaseItem.get(AbstractRepository.GAME_TITLE_COL).s())
                        .topScore(Integer.valueOf(databaseItem.get(AbstractRepository.TOP_SCORE_COL).n()))
                        .build())
                .orElse(null);
    }
}
