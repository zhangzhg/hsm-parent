package com.hsm.api.restapi.service;

import com.hsm.api.em.RestUrlEnum;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.Map;

public interface IRestService {
    <T> ResponseEntity<T> getObject(RestUrlEnum em, Class<T> responseType) throws Exception;

    <T> ResponseEntity<T> getObject(RestUrlEnum em, ParameterizedTypeReference<T> responseType) throws Exception;

    <T> ResponseEntity<T> getObject(RestUrlEnum em, Class<T> responseType, Map<String, ?> uriVariables) throws Exception;

    <T> ResponseEntity<T> getObject(RestUrlEnum em, ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables) throws Exception;

    <T> ResponseEntity<T> postObject(RestUrlEnum em, HttpEntity<?> request, Class<T> responseType, Object... uriVariables) throws Exception;

    <T> ResponseEntity<T> postObject(RestUrlEnum em, HttpEntity<?> request, Class<T> responseType, Map<String, ?> uriVariables) throws Exception;

    <T> ResponseEntity<T> postObject(URI url, HttpEntity<?> request, Class<T> responseType) throws Exception;


}
