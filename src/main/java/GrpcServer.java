
import io.grpc.stub.StreamObserver;
import org.example.streaming.streamingserverservice.*;

import java.util.ArrayList;

public class
GrpcServer extends StreamingServerServiceGrpc.StreamingServerServiceImplBase  {
    ArrayList<String> name = new ArrayList<>();

    @Override
    public void sendUnaryRequest(UnaryRequest request, StreamObserver<UnaryResponse> responseObserver) {
        String clientName = request.getName();
        String message = "Hello world! " + clientName + "! This is a unary response from the server";
        UnaryResponse response = UnaryResponse.newBuilder()
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
