package com.apps.org.entity.generators;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareGenerator implements AuditorAware<String> {

	private String xAuthUser = "APILock";

	@Override
    public Optional<String> getCurrentAuditor() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object pricipal = auth.getPrincipal();
		String user="";
        return Optional.of(xAuthUser);
    }

	public String getxAuthUser() {
		return xAuthUser;
	}

	public void setxAuthUser(String xAuthUser) {
		this.xAuthUser = xAuthUser;
	}
}