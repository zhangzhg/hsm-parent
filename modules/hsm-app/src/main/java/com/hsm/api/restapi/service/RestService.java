package com.hsm.api.restapi.service;

import com.hsm.api.em.RestUrlEnum;
import com.hsm.api.properties.RestApiProperties;
import com.framework.core.http.impl.AsynClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

/**
 * 代理一层， 将通用的参数设置进去
 */
@Service
public class RestService implements IRestService {
    @Autowired
    RestApiProperties restApiProperties;
    @Autowired
    AsynClientTemplate asynClientTemplate;

    /**
     * @param responseType 复杂或者未知类型可以用JSONObject.class
     */
    @Override
    public <T> ResponseEntity<T> getObject(RestUrlEnum em, Class<T> responseType) throws Exception {
        String url = restApiProperties.build(em, null);
        return asynClientTemplate.getObject(url, responseType);
    }

    @Override
    public <T> ResponseEntity<T> getObject(RestUrlEnum em, ParameterizedTypeReference<T> responseType) throws Exception {
        String url = restApiProperties.build(em, null);
        return asynClientTemplate.getObject(url, responseType);
    }

    @Override
    public <T> ResponseEntity<T> getObject(RestUrlEnum em, Class<T> responseType, Map<String, ?> uriVariables) throws Exception {
        String url = restApiProperties.build(em, uriVariables);
        return asynClientTemplate.getObject(url, responseType);
    }

    @Override
    public <T> ResponseEntity<T> getObject(RestUrlEnum em, ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables) throws Exception {
        String url = restApiProperties.build(em, null);
        return asynClientTemplate.getObject(url, responseType, uriVariables);
    }

    @Override
    public <T> ResponseEntity<T> postObject(RestUrlEnum em, HttpEntity<?> request, Class<T> responseType, Object... uriVariables) throws Exception {
        String url = restApiProperties.buildPostUrl(em);
        return asynClientTemplate.postObject(url, request, responseType, uriVariables);
    }

    @Override
    public <T> ResponseEntity<T> postObject(RestUrlEnum em,HttpEntity<?> request, Class<T> responseType, Map<String, ?> uriVariables) throws Exception {
        String url = restApiProperties.buildPostUrl(em);
        return asynClientTemplate.postObject(url, request, responseType, uriVariables);
    }

    @Override
    public <T> ResponseEntity<T> postObject(URI uri, HttpEntity<?> request, Class<T> responseType) throws Exception {
        return asynClientTemplate.postObject(uri, request, responseType);
    }

}
