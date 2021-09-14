package com.apps.org.model.response;

import java.util.ArrayList;

import com.apps.org.model.Errors;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse extends ArrayList<Errors> {

	private static final long serialVersionUID = 173731040772214215L;

}
