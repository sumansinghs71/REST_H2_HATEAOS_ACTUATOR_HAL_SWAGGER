package com.hub.rest.rest_H2.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	//URI Versioning 
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}

	//URI Versioning 
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// Parameter Versioning, should be passed as parameter in the url Ex: /person/param?version=1
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Bob Charlie");
	}

	// Parameter Versioning, should be passed as parameter in the url Ex: /person/param?version=2
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	
	// Header Versioning, should be passed in headers as X-API-VERSION:1, caching is easy here since we have versioning
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Bob Charlie");
	}

	// Header Versioning, should be passed in headers as X-API-VERSION:2, caching is easy here since we have versioning
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// MIME type or Accept header versioning , should be passes as Accept:application/vnd.company.app-v1+json in the headers,, caching is easy here since we have versioning 
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Bob Charlie");
	}

	// MIME type or Accept header versioning , should be passes as Accept:application/vnd.company.app-v1+json in the headers, caching is easy here since we have versioning
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

}