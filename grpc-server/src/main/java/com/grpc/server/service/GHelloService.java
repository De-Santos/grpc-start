package com.grpc.server.service;

import com.grpc.Dto;
import com.grpc.TestServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;

@Log4j2
@GrpcService
public class GHelloService extends TestServiceGrpc.TestServiceImplBase {

	@Override
	public void getHello(Dto.EmptyRequest request, StreamObserver<Dto.HelloResponse> responseObserver) {
		log.info("Received Message with hash code: {}", request.hashCode());
		Dto.HelloResponse response = Dto.HelloResponse.newBuilder()
				.setMessage("Hello From Server. ")
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
