package grpc.newService;


import java.io.IOException;

import grpc.newService.newServiceGrpc.newServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class NewServer {
	
	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		NewServer ourServer = new NewServer();
		ourServer.start();		
	}
	
	private void start() throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		
		int port = 50051;
		
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		System.out.println("Server runniing on port: " + port);
		
		server.awaitTermination();
						
	}
	
	//Extend abstract base class for our implementaiton
	
	static class NewServerImpl extends newServiceImplBase {
		
		@Override
		public void getFirstString(containsString request, StreamObserver<containsString> responseObserver) {
		
			//Find out what was sent by the client
			String firstString = request.getFirstString();
			System.out.println("firstString is: " + firstString);
			
			//Now build our response
			
			containsString.Builder response = containsString.newBuilder();
			
			response.setFirstString("Our First response string: " + firstString);
			
			responseObserver.onNext(response.build());
			
			responseObserver.onCompleted();
			
		}
		
	}
		
	}
	
	


