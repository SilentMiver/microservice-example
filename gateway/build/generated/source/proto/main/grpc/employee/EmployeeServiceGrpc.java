package employee;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.0)",
    comments = "Source: employee.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EmployeeServiceGrpc {

  private EmployeeServiceGrpc() {}

  public static final String SERVICE_NAME = "employee.EmployeeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<employee.EmployeeOuterClass.Empty,
      employee.EmployeeOuterClass.EmployeeList> getGetAllEmployeesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllEmployees",
      requestType = employee.EmployeeOuterClass.Empty.class,
      responseType = employee.EmployeeOuterClass.EmployeeList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<employee.EmployeeOuterClass.Empty,
      employee.EmployeeOuterClass.EmployeeList> getGetAllEmployeesMethod() {
    io.grpc.MethodDescriptor<employee.EmployeeOuterClass.Empty, employee.EmployeeOuterClass.EmployeeList> getGetAllEmployeesMethod;
    if ((getGetAllEmployeesMethod = EmployeeServiceGrpc.getGetAllEmployeesMethod) == null) {
      synchronized (EmployeeServiceGrpc.class) {
        if ((getGetAllEmployeesMethod = EmployeeServiceGrpc.getGetAllEmployeesMethod) == null) {
          EmployeeServiceGrpc.getGetAllEmployeesMethod = getGetAllEmployeesMethod =
              io.grpc.MethodDescriptor.<employee.EmployeeOuterClass.Empty, employee.EmployeeOuterClass.EmployeeList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllEmployees"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  employee.EmployeeOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  employee.EmployeeOuterClass.EmployeeList.getDefaultInstance()))
              .setSchemaDescriptor(new EmployeeServiceMethodDescriptorSupplier("GetAllEmployees"))
              .build();
        }
      }
    }
    return getGetAllEmployeesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<employee.EmployeeOuterClass.EmployeeRequest,
      employee.EmployeeOuterClass.Employee> getGetEmployeeByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEmployeeById",
      requestType = employee.EmployeeOuterClass.EmployeeRequest.class,
      responseType = employee.EmployeeOuterClass.Employee.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<employee.EmployeeOuterClass.EmployeeRequest,
      employee.EmployeeOuterClass.Employee> getGetEmployeeByIdMethod() {
    io.grpc.MethodDescriptor<employee.EmployeeOuterClass.EmployeeRequest, employee.EmployeeOuterClass.Employee> getGetEmployeeByIdMethod;
    if ((getGetEmployeeByIdMethod = EmployeeServiceGrpc.getGetEmployeeByIdMethod) == null) {
      synchronized (EmployeeServiceGrpc.class) {
        if ((getGetEmployeeByIdMethod = EmployeeServiceGrpc.getGetEmployeeByIdMethod) == null) {
          EmployeeServiceGrpc.getGetEmployeeByIdMethod = getGetEmployeeByIdMethod =
              io.grpc.MethodDescriptor.<employee.EmployeeOuterClass.EmployeeRequest, employee.EmployeeOuterClass.Employee>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEmployeeById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  employee.EmployeeOuterClass.EmployeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  employee.EmployeeOuterClass.Employee.getDefaultInstance()))
              .setSchemaDescriptor(new EmployeeServiceMethodDescriptorSupplier("GetEmployeeById"))
              .build();
        }
      }
    }
    return getGetEmployeeByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmployeeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceStub>() {
        @java.lang.Override
        public EmployeeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmployeeServiceStub(channel, callOptions);
        }
      };
    return EmployeeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmployeeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceBlockingStub>() {
        @java.lang.Override
        public EmployeeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmployeeServiceBlockingStub(channel, callOptions);
        }
      };
    return EmployeeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmployeeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmployeeServiceFutureStub>() {
        @java.lang.Override
        public EmployeeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmployeeServiceFutureStub(channel, callOptions);
        }
      };
    return EmployeeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EmployeeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllEmployees(employee.EmployeeOuterClass.Empty request,
        io.grpc.stub.StreamObserver<employee.EmployeeOuterClass.EmployeeList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllEmployeesMethod(), responseObserver);
    }

    /**
     */
    public void getEmployeeById(employee.EmployeeOuterClass.EmployeeRequest request,
        io.grpc.stub.StreamObserver<employee.EmployeeOuterClass.Employee> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEmployeeByIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllEmployeesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                employee.EmployeeOuterClass.Empty,
                employee.EmployeeOuterClass.EmployeeList>(
                  this, METHODID_GET_ALL_EMPLOYEES)))
          .addMethod(
            getGetEmployeeByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                employee.EmployeeOuterClass.EmployeeRequest,
                employee.EmployeeOuterClass.Employee>(
                  this, METHODID_GET_EMPLOYEE_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class EmployeeServiceStub extends io.grpc.stub.AbstractAsyncStub<EmployeeServiceStub> {
    private EmployeeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmployeeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllEmployees(employee.EmployeeOuterClass.Empty request,
        io.grpc.stub.StreamObserver<employee.EmployeeOuterClass.EmployeeList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllEmployeesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEmployeeById(employee.EmployeeOuterClass.EmployeeRequest request,
        io.grpc.stub.StreamObserver<employee.EmployeeOuterClass.Employee> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEmployeeByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EmployeeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<EmployeeServiceBlockingStub> {
    private EmployeeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmployeeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public employee.EmployeeOuterClass.EmployeeList getAllEmployees(employee.EmployeeOuterClass.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllEmployeesMethod(), getCallOptions(), request);
    }

    /**
     */
    public employee.EmployeeOuterClass.Employee getEmployeeById(employee.EmployeeOuterClass.EmployeeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEmployeeByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmployeeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<EmployeeServiceFutureStub> {
    private EmployeeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmployeeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<employee.EmployeeOuterClass.EmployeeList> getAllEmployees(
        employee.EmployeeOuterClass.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllEmployeesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<employee.EmployeeOuterClass.Employee> getEmployeeById(
        employee.EmployeeOuterClass.EmployeeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEmployeeByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_EMPLOYEES = 0;
  private static final int METHODID_GET_EMPLOYEE_BY_ID = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmployeeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmployeeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_EMPLOYEES:
          serviceImpl.getAllEmployees((employee.EmployeeOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<employee.EmployeeOuterClass.EmployeeList>) responseObserver);
          break;
        case METHODID_GET_EMPLOYEE_BY_ID:
          serviceImpl.getEmployeeById((employee.EmployeeOuterClass.EmployeeRequest) request,
              (io.grpc.stub.StreamObserver<employee.EmployeeOuterClass.Employee>) responseObserver);
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

  private static abstract class EmployeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmployeeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return employee.EmployeeOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmployeeService");
    }
  }

  private static final class EmployeeServiceFileDescriptorSupplier
      extends EmployeeServiceBaseDescriptorSupplier {
    EmployeeServiceFileDescriptorSupplier() {}
  }

  private static final class EmployeeServiceMethodDescriptorSupplier
      extends EmployeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EmployeeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EmployeeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmployeeServiceFileDescriptorSupplier())
              .addMethod(getGetAllEmployeesMethod())
              .addMethod(getGetEmployeeByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
