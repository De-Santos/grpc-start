package com.grpc.client;


import com.google.protobuf.Empty;
import com.grpc.TestServiceGrpc;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class GClientService {

	@GrpcClient("grpc-server")
	private TestServiceGrpc.TestServiceBlockingStub testServiceBlockingStub;

	public String receiveGreeting() {

		Empty request = Empty.newBuilder().build();
		return testServiceBlockingStub.getHello(request).getMessage();
	}
}
