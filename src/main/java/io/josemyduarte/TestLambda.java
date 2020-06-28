package io.josemyduarte;

import javax.inject.Inject;
import javax.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.josemyduarte.service.GameScoreRepository;
import io.josemyduarte.view.DynamoGameScore;
import io.josemyduarte.view.GameScoreRequest;

@Named("test")
public class TestLambda implements RequestHandler<GameScoreRequest, DynamoGameScore> {

    @Inject
    GameScoreRepository repository;

    @Override
    public DynamoGameScore handleRequest(final GameScoreRequest input, final Context context) {
        System.out.println(input);
        return repository.get(input.getUserId());
    }
}
