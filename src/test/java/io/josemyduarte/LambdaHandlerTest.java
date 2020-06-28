package io.josemyduarte;

import io.josemyduarte.view.DynamoGameScore;
import io.josemyduarte.view.GameScoreRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.amazon.lambda.test.LambdaClient;
import io.quarkus.test.junit.QuarkusTest;

import java.util.UUID;

@QuarkusTest
public class LambdaHandlerTest {

    @Test
    public void testSimpleLambdaSuccess() throws Exception {
//        GameScoreRequest in = new GameScoreRequest();
//        in.setUserId(UUID.randomUUID().toString());
//        DynamoGameScore out = LambdaClient.invoke(DynamoGameScore.class, in);
//        Assertions.assertEquals("Hello Stu", out.getResult());
//        Assertions.assertTrue(out.getRequestId().matches("aws-request-\\d"), "Expected requestId as 'aws-request-<number>'");
    }

}
