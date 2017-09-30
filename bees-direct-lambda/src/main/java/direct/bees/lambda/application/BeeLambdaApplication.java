package direct.bees.lambda.application;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import direct.bees.lambda.BeeLambda;
import direct.bees.lambda.module.BeeLambdaModule;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BeeLambdaApplication implements RequestStreamHandler {

    BeeLambdaModule beeLambdaModule = new BeeLambdaModule();
    BeeLambda lambda = beeLambdaModule.lambda();

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        lambda.handleRequest(input, output, context);
    }
}
