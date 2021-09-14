package com.apps.org.model.request;

import java.util.ArrayList;

import com.apps.org.model.EmployeeIOModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class EmployeeRequest extends ArrayList<EmployeeIOModel> {

	private static final long serialVersionUID = -5147823672448069482L;
	

}
