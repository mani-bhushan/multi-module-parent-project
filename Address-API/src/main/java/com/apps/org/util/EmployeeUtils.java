package com.apps.org.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;

import com.apps.org.entity.Address;
import com.apps.org.entity.Employee;
import com.apps.org.model.EmployeeIOModel;
import com.apps.org.model.Errors;
import com.apps.org.model.response.EmployeeResponse;
import com.apps.org.model.response.ErrorResponse;
import com.apps.org.model.response.PageResponse;

public class EmployeeUtils {

	public static Employee populateEmployeeEntityFromEmployeeRequest(EmployeeIOModel employeeRequest) {
		
		Employee employee = new  Employee();
		employee.setEmpName(employeeRequest.getEmpName());
		employee.setBirthDate(DateUtils.convertStringToUtilDate(employeeRequest.getBirthDate()));
		employee.setHireDate(DateUtils.convertStringToUtilDate(employeeRequest.getHireDate()));
		employee.setGender(employeeRequest.getGender());
		employee.setDesignation(employeeRequest.getDesignation());
		employee.setNationality(employeeRequest.getNationality().toUpperCase());
		employee.setIsActive(AppConstants.Y.stringValue.equalsIgnoreCase(employeeRequest.getIsActive()));
		employee.setStartDate(DateUtils.convertStringToUtilDate(employeeRequest.getStartDate()));
		employee.setDueDate(DateUtils.convertStringToUtilDate(employeeRequest.getDueDate()));
		employee.setEndDate(DateUtils.convertStringToUtilDate(employeeRequest.getEndDate()));
		employee.setAddressList(populateAddressEntityFromEmployeeRequest(employeeRequest, employee));
		
		return employee;
	}
	
	public static Set<Address> populateAddressEntityFromEmployeeRequest(EmployeeIOModel employeeRequest, Employee employee) {
		
		Set<Address> addressList = new HashSet<Address>();
		employeeRequest.getAddress().forEach(addressReq -> {
			
			Address address = new Address();
			address.setAddressLine(addressReq.getAddressLine());
			address.setHouseNumber(addressReq.getHouseNumber());
			address.setStreetName(addressReq.getStreetName());
			address.setCity(addressReq.getCity());
			address.setState(addressReq.getState());
			address.setCountry(addressReq.getCountry());
			address.setStdCode(addressReq.getStdCode());
			address.setTelephone(addressReq.getTelephone());
			address.setLat(addressReq.getLat());
			address.setLon(addressReq.getLon());
			address.setCountryCode(addressReq.getCountryCode());
			address.setMobile(addressReq.getMobile());
			address.setZipCode(addressReq.getZipCode());
			address.setEmployee(employee);
			address.setIsPrimary(AppConstants.Y.stringValue.equalsIgnoreCase(addressReq.getIsPrimary()));
			
			addressList.add(address);
			
		});
		
		return addressList;
	}

	public static PageResponse populateResponse(List<Employee> employees) {
		PageResponse pageResponse = new PageResponse();
		EmployeeResponse employeeResponse = new EmployeeResponse();
		for (Employee employee : employees) {
			EmployeeIOModel employeeIOModel = new EmployeeIOModel(true);
			employeeIOModel.setEmpId(employee.getEmpId());
			employeeIOModel.setEmpName(employee.getEmpName());
			employeeIOModel.setDesignation(employee.getDesignation());
			employeeIOModel.setGender(employee.getGender());
			employeeResponse.add(employeeIOModel);
		}
		pageResponse.setEmployeeResponse(employeeResponse);
		return pageResponse;
	}

	public static PageResponse populateHeaders(PageResponse pageResponse, Page<Employee> employeePage ) {
		if (null == pageResponse) pageResponse = new PageResponse();
		pageResponse.setCurrentPage(String.valueOf(employeePage.getNumber()));
		pageResponse.setTotalElements(String.valueOf(employeePage.getTotalElements()));
		pageResponse.setTotalElements(String.valueOf(employeePage.getTotalPages()));
		return pageResponse;

	}

	public static EmployeeIOModel populateEmployeeErrorsInResponseModel(EmployeeIOModel employeeRequest) {
		EmployeeIOModel employeeIOModel = new EmployeeIOModel(true);
		employeeIOModel.setEmpId(employeeRequest.getEmpId());
		employeeIOModel.setEmpName(employeeRequest.getEmpName());
		employeeIOModel.setBirthDate(employeeRequest.getBirthDate());
		employeeIOModel.setGender(employeeRequest.getGender());
		return employeeIOModel;
	}

	public static EmployeeResponse populateEmployeeResponse(List<Employee> employees) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employees.forEach(employee -> {
			EmployeeIOModel employeeIOModel = new EmployeeIOModel();
			employeeIOModel.setEmpId(employee.getEmpId());
			employeeIOModel.setEmpName(employee.getEmpName());
			employeeIOModel.setBirthDate(DateUtils.convertUtilDateToString(employee.getBirthDate()));
			employeeIOModel.setGender(employee.getGender());
			employeeResponse.add(employeeIOModel);
		});
		return employeeResponse;
	}

	public static Errors populateErrorResponse(
			EmployeeIOModel employeeresponse, Integer errorCode,
			String errorMessage, Exception ex) {

		Errors errors = new Errors();
		StringBuffer buffer = new StringBuffer(errorMessage);

		if (null != employeeresponse) {
			EmployeeIOModel modelResponse = populateEmployeeErrorsInResponseModel(employeeresponse);
			errors.setEmployeeResponse(modelResponse);
		}
		if (null != ex) {
			buffer.append(ex.getMessage());
			errors.setCause(ex.getCause());
		}
		errors.setErrorCode(errorCode);
		errors.setMessage(buffer.toString());
		
		return errors;
	}

	public static HttpHeaders populateHttpHeaders(PageResponse response) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Current-Page", response.getCurrentPage());
		headers.add("X-Total-Elements", response.getTotalElements());
		headers.add("X-Total-Pages", response.getTotalPages());
		return headers;
	}

	public static boolean validateAddEmployeeRequest(EmployeeIOModel requestObj, ErrorResponse errorResponse) {
		
		StringBuffer errorData = new StringBuffer();
		if (StringUtils.isBlank(requestObj.getEmpName())) {
			errorData.append("Employee Name, ");
		}
		if (StringUtils.isBlank(requestObj.getBirthDate())) {
			errorData.append("Birth Date, ");
		}
		if (StringUtils.isBlank(requestObj.getGender())) {
			errorData.append("Gender, ");
		}
		if (StringUtils.isBlank(requestObj.getDesignation())) {
			errorData.append("Designation : Please provide designation, ");
		}
		if (StringUtils.isBlank(requestObj.getHireDate())) {
			errorData.append("Hire Date : Please provide date of hiring, ");
		}
		if (StringUtils.isBlank(requestObj.getNationality())) {
			errorData.append("Nationality : Please provide nationality, ");
		}
		if (StringUtils.isBlank(requestObj.getIsActive())
				|| ! ( AppConstants.Y.stringValue.equalsIgnoreCase(requestObj.getIsActive()) 
						|| AppConstants.N.stringValue.equalsIgnoreCase(requestObj.getIsActive()))) {
			errorData.append("Is Active : Please provide active status, ");
		}
		if (CollectionUtils.isEmpty(requestObj.getAddress())) {
			errorData.append("Address : Please provide an address, ");
		}
		requestObj.getAddress().forEach(address -> {
			
			if ( AppConstants.ONE.integerValue == requestObj.getAddress().size()) {
				if ( StringUtils.isBlank(address.getIsPrimary())
						|| ( ! AppConstants.Y.stringValue.equalsIgnoreCase(address.getIsPrimary()))) {
					errorData.append("IsPrimary : Please provide a primary address, ");
				}
			}
			if (StringUtils.isBlank(address.getAddressLine())) {
				errorData.append("AddressLine, ");
			}
			if (StringUtils.isBlank(address.getHouseNumber())) {
				errorData.append("HouseNumber, ");
			}
			if (StringUtils.isBlank(address.getStreetName())) {
				errorData.append("StreetName, ");
			}
			if (StringUtils.isBlank(address.getCountry())) {
				errorData.append("Country, ");
			}
			if (StringUtils.isBlank(address.getState())) {
				errorData.append("State, ");
			}
			if (StringUtils.isBlank(address.getCity())) {
				errorData.append("City, ");
			}
			if (null ==address.getCountryCode()) {
				errorData.append("CountryCode, ");
			}
			if (address.getCountryCode() < 0) {
				errorData.append("CountryCode <  0, ");
			}
			if (null == address.getMobile()) {
				errorData.append("MobileNumber, ");
			}
			if (address.getMobile() < 0) {
				errorData.append("MobileNumber < 0, ");
			}
			if (null == address.getZipCode()) {
				errorData.append("ZipCode, ");
			}
			if (address.getZipCode() < 0) {
				errorData.append("ZipCode < 0, ");
			}
		});
		
		if(StringUtils.isNotBlank(errorData)) {
			Errors errors = new Errors();
			errors.setErrorCode(AppElements.FIELDS_MISSING.code);
			errors.setMessage(AppElements.FIELDS_MISSING.message + cleanUpCommas(errorData.toString()));
			errorResponse.add(errors);
			return false;
		}
		
		return true;
	}
	
	public static String cleanUpCommas(String string) {
		
        return string.replaceAll(", $", ".");
    }

}
