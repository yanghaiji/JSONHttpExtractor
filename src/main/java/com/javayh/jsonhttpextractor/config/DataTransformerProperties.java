package com.javayh.jsonhttpextractor.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2024-02-22
 */
@Data
@ConfigurationProperties(prefix = "json.mapping")
public class DataTransformerProperties {

    private List<TransformConfig> transforms;

    public List<TransformConfig> getTransforms() {
        return transforms;
    }

    public void setTransforms(List<TransformConfig> transforms) {
        this.transforms = transforms;
    }

    @Data
    public static class TransformConfig {
        /**
         * 唯一标识，用于动态的读取 对应的配置
         * 推荐使用就有夜壶含义的唯一标识
         */
        private String type;
        /**
         * 附加的描述
         */
        private String title;
        /**
         * 具体的mapping 逻辑
         */
        private List<JsonMappingProperties> mappings;

    }

}



