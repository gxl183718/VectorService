package iie.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: vector.proto")
public final class VectorGrpc {

  private VectorGrpc() {}

  public static final String SERVICE_NAME = "Vector";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<iie.grpc.Test,
      iie.grpc.Test> getTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "test",
      requestType = iie.grpc.Test.class,
      responseType = iie.grpc.Test.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iie.grpc.Test,
      iie.grpc.Test> getTestMethod() {
    io.grpc.MethodDescriptor<iie.grpc.Test, iie.grpc.Test> getTestMethod;
    if ((getTestMethod = VectorGrpc.getTestMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getTestMethod = VectorGrpc.getTestMethod) == null) {
          VectorGrpc.getTestMethod = getTestMethod = 
              io.grpc.MethodDescriptor.<iie.grpc.Test, iie.grpc.Test>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "test"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.Test.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.Test.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("test"))
                  .build();
          }
        }
     }
     return getTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<iie.grpc.VectorRequest,
      iie.grpc.VectorResponse> getSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "search",
      requestType = iie.grpc.VectorRequest.class,
      responseType = iie.grpc.VectorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iie.grpc.VectorRequest,
      iie.grpc.VectorResponse> getSearchMethod() {
    io.grpc.MethodDescriptor<iie.grpc.VectorRequest, iie.grpc.VectorResponse> getSearchMethod;
    if ((getSearchMethod = VectorGrpc.getSearchMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getSearchMethod = VectorGrpc.getSearchMethod) == null) {
          VectorGrpc.getSearchMethod = getSearchMethod = 
              io.grpc.MethodDescriptor.<iie.grpc.VectorRequest, iie.grpc.VectorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "search"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.VectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.VectorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("search"))
                  .build();
          }
        }
     }
     return getSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<iie.grpc.ImageBytes,
      iie.grpc.LocateEntries> getGetObjectsByBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getObjectsByBytes",
      requestType = iie.grpc.ImageBytes.class,
      responseType = iie.grpc.LocateEntries.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iie.grpc.ImageBytes,
      iie.grpc.LocateEntries> getGetObjectsByBytesMethod() {
    io.grpc.MethodDescriptor<iie.grpc.ImageBytes, iie.grpc.LocateEntries> getGetObjectsByBytesMethod;
    if ((getGetObjectsByBytesMethod = VectorGrpc.getGetObjectsByBytesMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getGetObjectsByBytesMethod = VectorGrpc.getGetObjectsByBytesMethod) == null) {
          VectorGrpc.getGetObjectsByBytesMethod = getGetObjectsByBytesMethod = 
              io.grpc.MethodDescriptor.<iie.grpc.ImageBytes, iie.grpc.LocateEntries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "getObjectsByBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.ImageBytes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.LocateEntries.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("getObjectsByBytes"))
                  .build();
          }
        }
     }
     return getGetObjectsByBytesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<iie.grpc.ImageUrl,
      iie.grpc.LocateEntries> getGetObjectsByUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getObjectsByUrl",
      requestType = iie.grpc.ImageUrl.class,
      responseType = iie.grpc.LocateEntries.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iie.grpc.ImageUrl,
      iie.grpc.LocateEntries> getGetObjectsByUrlMethod() {
    io.grpc.MethodDescriptor<iie.grpc.ImageUrl, iie.grpc.LocateEntries> getGetObjectsByUrlMethod;
    if ((getGetObjectsByUrlMethod = VectorGrpc.getGetObjectsByUrlMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getGetObjectsByUrlMethod = VectorGrpc.getGetObjectsByUrlMethod) == null) {
          VectorGrpc.getGetObjectsByUrlMethod = getGetObjectsByUrlMethod = 
              io.grpc.MethodDescriptor.<iie.grpc.ImageUrl, iie.grpc.LocateEntries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "getObjectsByUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.ImageUrl.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.LocateEntries.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("getObjectsByUrl"))
                  .build();
          }
        }
     }
     return getGetObjectsByUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<iie.grpc.BytesRequest,
      iie.grpc.BytesResponse> getSearchByBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchByBytes",
      requestType = iie.grpc.BytesRequest.class,
      responseType = iie.grpc.BytesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iie.grpc.BytesRequest,
      iie.grpc.BytesResponse> getSearchByBytesMethod() {
    io.grpc.MethodDescriptor<iie.grpc.BytesRequest, iie.grpc.BytesResponse> getSearchByBytesMethod;
    if ((getSearchByBytesMethod = VectorGrpc.getSearchByBytesMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getSearchByBytesMethod = VectorGrpc.getSearchByBytesMethod) == null) {
          VectorGrpc.getSearchByBytesMethod = getSearchByBytesMethod = 
              io.grpc.MethodDescriptor.<iie.grpc.BytesRequest, iie.grpc.BytesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "searchByBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.BytesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.BytesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("searchByBytes"))
                  .build();
          }
        }
     }
     return getSearchByBytesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<iie.grpc.UrlRequest,
      iie.grpc.BytesResponse> getSearchByUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchByUrl",
      requestType = iie.grpc.UrlRequest.class,
      responseType = iie.grpc.BytesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iie.grpc.UrlRequest,
      iie.grpc.BytesResponse> getSearchByUrlMethod() {
    io.grpc.MethodDescriptor<iie.grpc.UrlRequest, iie.grpc.BytesResponse> getSearchByUrlMethod;
    if ((getSearchByUrlMethod = VectorGrpc.getSearchByUrlMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getSearchByUrlMethod = VectorGrpc.getSearchByUrlMethod) == null) {
          VectorGrpc.getSearchByUrlMethod = getSearchByUrlMethod = 
              io.grpc.MethodDescriptor.<iie.grpc.UrlRequest, iie.grpc.BytesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "searchByUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.UrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.BytesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("searchByUrl"))
                  .build();
          }
        }
     }
     return getSearchByUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<iie.grpc.QueryByBytesEntry,
      iie.grpc.ResultEntryHash> getGetVectorByBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVectorByBytes",
      requestType = iie.grpc.QueryByBytesEntry.class,
      responseType = iie.grpc.ResultEntryHash.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iie.grpc.QueryByBytesEntry,
      iie.grpc.ResultEntryHash> getGetVectorByBytesMethod() {
    io.grpc.MethodDescriptor<iie.grpc.QueryByBytesEntry, iie.grpc.ResultEntryHash> getGetVectorByBytesMethod;
    if ((getGetVectorByBytesMethod = VectorGrpc.getGetVectorByBytesMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getGetVectorByBytesMethod = VectorGrpc.getGetVectorByBytesMethod) == null) {
          VectorGrpc.getGetVectorByBytesMethod = getGetVectorByBytesMethod = 
              io.grpc.MethodDescriptor.<iie.grpc.QueryByBytesEntry, iie.grpc.ResultEntryHash>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "getVectorByBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.QueryByBytesEntry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.ResultEntryHash.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("getVectorByBytes"))
                  .build();
          }
        }
     }
     return getGetVectorByBytesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<iie.grpc.QueryByUrlEntry,
      iie.grpc.ResultEntryHash> getGetVectorByUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVectorByUrl",
      requestType = iie.grpc.QueryByUrlEntry.class,
      responseType = iie.grpc.ResultEntryHash.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iie.grpc.QueryByUrlEntry,
      iie.grpc.ResultEntryHash> getGetVectorByUrlMethod() {
    io.grpc.MethodDescriptor<iie.grpc.QueryByUrlEntry, iie.grpc.ResultEntryHash> getGetVectorByUrlMethod;
    if ((getGetVectorByUrlMethod = VectorGrpc.getGetVectorByUrlMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getGetVectorByUrlMethod = VectorGrpc.getGetVectorByUrlMethod) == null) {
          VectorGrpc.getGetVectorByUrlMethod = getGetVectorByUrlMethod = 
              io.grpc.MethodDescriptor.<iie.grpc.QueryByUrlEntry, iie.grpc.ResultEntryHash>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "getVectorByUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.QueryByUrlEntry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iie.grpc.ResultEntryHash.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("getVectorByUrl"))
                  .build();
          }
        }
     }
     return getGetVectorByUrlMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VectorStub newStub(io.grpc.Channel channel) {
    return new VectorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VectorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VectorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VectorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VectorFutureStub(channel);
  }

  /**
   */
  public static abstract class VectorImplBase implements io.grpc.BindableService {

    /**
     */
    public void test(iie.grpc.Test request,
        io.grpc.stub.StreamObserver<iie.grpc.Test> responseObserver) {
      asyncUnimplementedUnaryCall(getTestMethod(), responseObserver);
    }

    /**
     * <pre>
     *1.通过url批量获取vector
     * </pre>
     */
    public void search(iie.grpc.VectorRequest request,
        io.grpc.stub.StreamObserver<iie.grpc.VectorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }

    /**
     * <pre>
     *2.yolo v3实体识别接口
     * </pre>
     */
    public void getObjectsByBytes(iie.grpc.ImageBytes request,
        io.grpc.stub.StreamObserver<iie.grpc.LocateEntries> responseObserver) {
      asyncUnimplementedUnaryCall(getGetObjectsByBytesMethod(), responseObserver);
    }

    /**
     */
    public void getObjectsByUrl(iie.grpc.ImageUrl request,
        io.grpc.stub.StreamObserver<iie.grpc.LocateEntries> responseObserver) {
      asyncUnimplementedUnaryCall(getGetObjectsByUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     *3.查询向量接口，通过bytes或url
     * </pre>
     */
    public void searchByBytes(iie.grpc.BytesRequest request,
        io.grpc.stub.StreamObserver<iie.grpc.BytesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchByBytesMethod(), responseObserver);
    }

    /**
     */
    public void searchByUrl(iie.grpc.UrlRequest request,
        io.grpc.stub.StreamObserver<iie.grpc.BytesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchByUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     *4.向量服务提供的对外接口
     * </pre>
     */
    public void getVectorByBytes(iie.grpc.QueryByBytesEntry request,
        io.grpc.stub.StreamObserver<iie.grpc.ResultEntryHash> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVectorByBytesMethod(), responseObserver);
    }

    /**
     */
    public void getVectorByUrl(iie.grpc.QueryByUrlEntry request,
        io.grpc.stub.StreamObserver<iie.grpc.ResultEntryHash> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVectorByUrlMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iie.grpc.Test,
                iie.grpc.Test>(
                  this, METHODID_TEST)))
          .addMethod(
            getSearchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iie.grpc.VectorRequest,
                iie.grpc.VectorResponse>(
                  this, METHODID_SEARCH)))
          .addMethod(
            getGetObjectsByBytesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iie.grpc.ImageBytes,
                iie.grpc.LocateEntries>(
                  this, METHODID_GET_OBJECTS_BY_BYTES)))
          .addMethod(
            getGetObjectsByUrlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iie.grpc.ImageUrl,
                iie.grpc.LocateEntries>(
                  this, METHODID_GET_OBJECTS_BY_URL)))
          .addMethod(
            getSearchByBytesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iie.grpc.BytesRequest,
                iie.grpc.BytesResponse>(
                  this, METHODID_SEARCH_BY_BYTES)))
          .addMethod(
            getSearchByUrlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iie.grpc.UrlRequest,
                iie.grpc.BytesResponse>(
                  this, METHODID_SEARCH_BY_URL)))
          .addMethod(
            getGetVectorByBytesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iie.grpc.QueryByBytesEntry,
                iie.grpc.ResultEntryHash>(
                  this, METHODID_GET_VECTOR_BY_BYTES)))
          .addMethod(
            getGetVectorByUrlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iie.grpc.QueryByUrlEntry,
                iie.grpc.ResultEntryHash>(
                  this, METHODID_GET_VECTOR_BY_URL)))
          .build();
    }
  }

  /**
   */
  public static final class VectorStub extends io.grpc.stub.AbstractStub<VectorStub> {
    private VectorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VectorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VectorStub(channel, callOptions);
    }

    /**
     */
    public void test(iie.grpc.Test request,
        io.grpc.stub.StreamObserver<iie.grpc.Test> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *1.通过url批量获取vector
     * </pre>
     */
    public void search(iie.grpc.VectorRequest request,
        io.grpc.stub.StreamObserver<iie.grpc.VectorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *2.yolo v3实体识别接口
     * </pre>
     */
    public void getObjectsByBytes(iie.grpc.ImageBytes request,
        io.grpc.stub.StreamObserver<iie.grpc.LocateEntries> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetObjectsByBytesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getObjectsByUrl(iie.grpc.ImageUrl request,
        io.grpc.stub.StreamObserver<iie.grpc.LocateEntries> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetObjectsByUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *3.查询向量接口，通过bytes或url
     * </pre>
     */
    public void searchByBytes(iie.grpc.BytesRequest request,
        io.grpc.stub.StreamObserver<iie.grpc.BytesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchByBytesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchByUrl(iie.grpc.UrlRequest request,
        io.grpc.stub.StreamObserver<iie.grpc.BytesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchByUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *4.向量服务提供的对外接口
     * </pre>
     */
    public void getVectorByBytes(iie.grpc.QueryByBytesEntry request,
        io.grpc.stub.StreamObserver<iie.grpc.ResultEntryHash> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVectorByBytesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVectorByUrl(iie.grpc.QueryByUrlEntry request,
        io.grpc.stub.StreamObserver<iie.grpc.ResultEntryHash> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVectorByUrlMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VectorBlockingStub extends io.grpc.stub.AbstractStub<VectorBlockingStub> {
    private VectorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VectorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VectorBlockingStub(channel, callOptions);
    }

    /**
     */
    public iie.grpc.Test test(iie.grpc.Test request) {
      return blockingUnaryCall(
          getChannel(), getTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *1.通过url批量获取vector
     * </pre>
     */
    public iie.grpc.VectorResponse search(iie.grpc.VectorRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *2.yolo v3实体识别接口
     * </pre>
     */
    public iie.grpc.LocateEntries getObjectsByBytes(iie.grpc.ImageBytes request) {
      return blockingUnaryCall(
          getChannel(), getGetObjectsByBytesMethod(), getCallOptions(), request);
    }

    /**
     */
    public iie.grpc.LocateEntries getObjectsByUrl(iie.grpc.ImageUrl request) {
      return blockingUnaryCall(
          getChannel(), getGetObjectsByUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *3.查询向量接口，通过bytes或url
     * </pre>
     */
    public iie.grpc.BytesResponse searchByBytes(iie.grpc.BytesRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchByBytesMethod(), getCallOptions(), request);
    }

    /**
     */
    public iie.grpc.BytesResponse searchByUrl(iie.grpc.UrlRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchByUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *4.向量服务提供的对外接口
     * </pre>
     */
    public iie.grpc.ResultEntryHash getVectorByBytes(iie.grpc.QueryByBytesEntry request) {
      return blockingUnaryCall(
          getChannel(), getGetVectorByBytesMethod(), getCallOptions(), request);
    }

    /**
     */
    public iie.grpc.ResultEntryHash getVectorByUrl(iie.grpc.QueryByUrlEntry request) {
      return blockingUnaryCall(
          getChannel(), getGetVectorByUrlMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VectorFutureStub extends io.grpc.stub.AbstractStub<VectorFutureStub> {
    private VectorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VectorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VectorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<iie.grpc.Test> test(
        iie.grpc.Test request) {
      return futureUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *1.通过url批量获取vector
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<iie.grpc.VectorResponse> search(
        iie.grpc.VectorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *2.yolo v3实体识别接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<iie.grpc.LocateEntries> getObjectsByBytes(
        iie.grpc.ImageBytes request) {
      return futureUnaryCall(
          getChannel().newCall(getGetObjectsByBytesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<iie.grpc.LocateEntries> getObjectsByUrl(
        iie.grpc.ImageUrl request) {
      return futureUnaryCall(
          getChannel().newCall(getGetObjectsByUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *3.查询向量接口，通过bytes或url
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<iie.grpc.BytesResponse> searchByBytes(
        iie.grpc.BytesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchByBytesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<iie.grpc.BytesResponse> searchByUrl(
        iie.grpc.UrlRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchByUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *4.向量服务提供的对外接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<iie.grpc.ResultEntryHash> getVectorByBytes(
        iie.grpc.QueryByBytesEntry request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVectorByBytesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<iie.grpc.ResultEntryHash> getVectorByUrl(
        iie.grpc.QueryByUrlEntry request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVectorByUrlMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TEST = 0;
  private static final int METHODID_SEARCH = 1;
  private static final int METHODID_GET_OBJECTS_BY_BYTES = 2;
  private static final int METHODID_GET_OBJECTS_BY_URL = 3;
  private static final int METHODID_SEARCH_BY_BYTES = 4;
  private static final int METHODID_SEARCH_BY_URL = 5;
  private static final int METHODID_GET_VECTOR_BY_BYTES = 6;
  private static final int METHODID_GET_VECTOR_BY_URL = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VectorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VectorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEST:
          serviceImpl.test((iie.grpc.Test) request,
              (io.grpc.stub.StreamObserver<iie.grpc.Test>) responseObserver);
          break;
        case METHODID_SEARCH:
          serviceImpl.search((iie.grpc.VectorRequest) request,
              (io.grpc.stub.StreamObserver<iie.grpc.VectorResponse>) responseObserver);
          break;
        case METHODID_GET_OBJECTS_BY_BYTES:
          serviceImpl.getObjectsByBytes((iie.grpc.ImageBytes) request,
              (io.grpc.stub.StreamObserver<iie.grpc.LocateEntries>) responseObserver);
          break;
        case METHODID_GET_OBJECTS_BY_URL:
          serviceImpl.getObjectsByUrl((iie.grpc.ImageUrl) request,
              (io.grpc.stub.StreamObserver<iie.grpc.LocateEntries>) responseObserver);
          break;
        case METHODID_SEARCH_BY_BYTES:
          serviceImpl.searchByBytes((iie.grpc.BytesRequest) request,
              (io.grpc.stub.StreamObserver<iie.grpc.BytesResponse>) responseObserver);
          break;
        case METHODID_SEARCH_BY_URL:
          serviceImpl.searchByUrl((iie.grpc.UrlRequest) request,
              (io.grpc.stub.StreamObserver<iie.grpc.BytesResponse>) responseObserver);
          break;
        case METHODID_GET_VECTOR_BY_BYTES:
          serviceImpl.getVectorByBytes((iie.grpc.QueryByBytesEntry) request,
              (io.grpc.stub.StreamObserver<iie.grpc.ResultEntryHash>) responseObserver);
          break;
        case METHODID_GET_VECTOR_BY_URL:
          serviceImpl.getVectorByUrl((iie.grpc.QueryByUrlEntry) request,
              (io.grpc.stub.StreamObserver<iie.grpc.ResultEntryHash>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class VectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VectorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return iie.grpc.VectorServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Vector");
    }
  }

  private static final class VectorFileDescriptorSupplier
      extends VectorBaseDescriptorSupplier {
    VectorFileDescriptorSupplier() {}
  }

  private static final class VectorMethodDescriptorSupplier
      extends VectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VectorMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (VectorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VectorFileDescriptorSupplier())
              .addMethod(getTestMethod())
              .addMethod(getSearchMethod())
              .addMethod(getGetObjectsByBytesMethod())
              .addMethod(getGetObjectsByUrlMethod())
              .addMethod(getSearchByBytesMethod())
              .addMethod(getSearchByUrlMethod())
              .addMethod(getGetVectorByBytesMethod())
              .addMethod(getGetVectorByUrlMethod())
              .build();
        }
      }
    }
    return result;
  }
}
