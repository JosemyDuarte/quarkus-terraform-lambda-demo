package io.josemyduarte.view;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RegisterForReflection
public class GameScoreRequest {
    private String userId;
}
