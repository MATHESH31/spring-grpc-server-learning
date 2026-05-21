package com.learning.grpc.grpc;

import com.learning.grpc.service.EmployeeService;
import employee.v1.EmployeeGrpc;
import employee.v1.EmployeeOuterClass;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class EmployeeImpl extends EmployeeGrpc.EmployeeImplBase {

    private static final Logger log = LoggerFactory.getLogger(EmployeeImpl.class);
    private final EmployeeService employeeService;

    public EmployeeImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void getEmployee(EmployeeOuterClass.EmployeeRequest request,
                                                           StreamObserver<EmployeeOuterClass.EmployeeResponse> responseObserver) {
        try {
            responseObserver.onNext(employeeService.getEmployee(request.getId()));
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("Error occurred on getting Employee: {}", e.getMessage());
            responseObserver.onError(e);
        }
    }
}
