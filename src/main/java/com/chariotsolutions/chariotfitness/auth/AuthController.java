package com.chariotsolutions.chariotfitness.auth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthController {
	@GetMapping("/greetings")
	String helloUser(@AuthenticationPrincipal OidcUser user) {
		return "Hello " + user.getAttributes().get("preferred_username");
	}
}
