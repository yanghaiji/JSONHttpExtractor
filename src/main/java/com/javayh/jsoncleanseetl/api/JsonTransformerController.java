package com.javayh.jsoncleanseetl.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.javayh.jsoncleanseetl.etl.DataTransformer;
import com.javayh.jsoncleanseetl.http.ImportJsonRequest;
import com.javayh.jsoncleanseetl.http.SyncJsonRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 统一入口
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2024-02-26
 */
@Slf4j
@RestController
@RequestMapping(value = "/transformer")
public class JsonTransformerController {

    @Autowired
    private DataTransformer dataTransformer;

    /**
     * 手动导出json数据，进行解析
     *
     * @param request 导入的参数 {@link ImportJsonRequest}
     * @return JSONObject 根据配置返回需要的配置
     */
    @PostMapping(value = "/import")
    public ResponseEntity<JSONObject> importTransformer(@Valid @RequestBody ImportJsonRequest request) {
        return ResponseEntity.ok(dataTransformer.transform(request));
    }

    /**
     * <p>
     *      根据请求的url自定获取源数据并解析
     * </p>
     * @version 1.0.0
     * @author hai ji
     * @since 2024/2/27
     * @param request 请求参数的元数据 {@link SyncJsonRequest}
     * @return org.springframework.http.ResponseEntity<com.alibaba.fastjson.JSONObject>
     */
    @PostMapping(value = "/sync")
    public ResponseEntity<JSONObject> syncTransformer(@Valid @RequestBody SyncJsonRequest request) {
        return ResponseEntity.ok(dataTransformer.httpEtl(request));
    }
}
